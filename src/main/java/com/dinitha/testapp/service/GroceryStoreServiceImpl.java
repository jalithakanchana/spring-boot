package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.GroceryStore;
import com.dinitha.testapp.entity.UserComment;
import com.dinitha.testapp.repository.GroceryStoreRepository;
import com.dinitha.testapp.repository.UserCommentRepository;
import com.dinitha.testapp.utilities.SemanticAPI;
import com.dinitha.testapp.utilities.SemanticAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class GroceryStoreServiceImpl implements GroceryStoreService {

    @Autowired
    private GroceryStoreRepository groceryStoreRepository;

    @Autowired
    private UserCommentRepository userCommentRepository;

    @Autowired
    private SemanticAPI semanticAPI;

    @Override
    public List<GroceryStore> listGroceryStores() {
        return groceryStoreRepository.findAll();
    }

    @Override
    public List<GroceryStore> addGroceryStore(GroceryStore groceryStore) {
        groceryStoreRepository.save(groceryStore);
        return (List<GroceryStore>) groceryStore;
    }

    public List<GroceryStore> analyseComments() throws Exception {

        //get the grocery list
        List<GroceryStore> groceryStoreList = groceryStoreRepository.findAll();
        if(!groceryStoreList.isEmpty()) {
            for (GroceryStore groceryStore : groceryStoreList) {
                //get the comments per grocery
                List<UserComment> userComments =  userCommentRepository.findAllByGroceryId(groceryStore.getGroceryStoreId());
                int commentsCount = userComments.size();
                if(!userComments.isEmpty()){
                    float total = 0.0f;
                    float mean = 0.0f;
                    for (UserComment userComment:userComments) {
                        //calculate the magnitude and score
                        SemanticAPIResponse semanticAPIResponse = semanticAPI.semanticAnalysis(userComment.getComments());
                        float result = semanticAPIResponse.getMagnitude()*semanticAPIResponse.getScore();
                        total = total + result;
                    }
                    //calculate mean value for the magnitude and score values
                    mean = (total/commentsCount);
                    groceryStore.setMean(mean);
                }
            }
        }
        //sort comments list
        Collections.sort(groceryStoreList, new Comparator<GroceryStore>() {
            @Override
            public int compare(GroceryStore gs1, GroceryStore gs2) {
                return Float.compare(gs2.getMean(), gs1.getMean());
            }
        });
        return groceryStoreList;
    }
}
