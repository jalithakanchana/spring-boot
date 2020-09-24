package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.GroceryStore;
import com.dinitha.testapp.repository.GroceryStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryStoreServiceImpl implements GroceryStoreService {

    @Autowired
    private GroceryStoreRepository groceryStoreRepository;

    @Override
    public List<GroceryStore> listGroceryStores() {
        return groceryStoreRepository.findAll();
    }

    @Override
    public List<GroceryStore> addGroceryStore(GroceryStore groceryStore) {
        groceryStoreRepository.save(groceryStore);
        return (List<GroceryStore>) groceryStore;
    }
}
