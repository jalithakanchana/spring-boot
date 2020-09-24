package com.dinitha.testapp.repository;

import com.dinitha.testapp.entity.GroceryStore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroceryStoreRepository extends JpaRepository<GroceryStore, Long>{

}
