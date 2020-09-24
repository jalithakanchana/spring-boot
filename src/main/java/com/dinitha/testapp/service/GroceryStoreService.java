package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.GroceryStore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroceryStoreService {
    List<GroceryStore> listGroceryStores();

    List<GroceryStore> addGroceryStore(GroceryStore groceryStore);
}
