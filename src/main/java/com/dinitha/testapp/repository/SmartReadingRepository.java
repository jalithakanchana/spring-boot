package com.dinitha.testapp.repository;

import com.dinitha.testapp.entity.GroceryStore;
import com.dinitha.testapp.entity.SmartReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartReadingRepository extends JpaRepository<SmartReading, Long>{

}
