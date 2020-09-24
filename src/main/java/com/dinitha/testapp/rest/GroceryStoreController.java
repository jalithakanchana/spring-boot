package com.dinitha.testapp.rest;

import com.dinitha.testapp.entity.GroceryStore;
import com.dinitha.testapp.service.GroceryStoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/groceryStore")
public class GroceryStoreController {
    private final Logger log = LoggerFactory.getLogger(GroceryStoreController.class);

    @Autowired
    private GroceryStoreService groceryStoreService;

    @GetMapping("/list")
    public ResponseEntity<List<GroceryStore>> getGroceryStoreList(){
        log.info("HTTP GET --> retrieveFunderTypes -->  /firebase/url");
        return ResponseEntity.ok(groceryStoreService.listGroceryStores());
    }

    @GetMapping("/add")
    public ResponseEntity addGroceryStore(GroceryStore groceryStore){
        log.info("HTTP GET --> retrieveFunderTypes -->  /firebase/url");
        return ResponseEntity.ok(groceryStoreService.addGroceryStore(groceryStore));
    }
}
