package com.dinitha.testapp.rest;

import com.dinitha.testapp.entity.GroceryStore;
import com.dinitha.testapp.entity.SmartReading;
import com.dinitha.testapp.service.GroceryStoreService;
import com.dinitha.testapp.service.SmartReadingService;
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
@RequestMapping("/v1/smartReading")
public class SmartReadingController {
    private final Logger log = LoggerFactory.getLogger(SmartReadingController.class);

    @Autowired
    private SmartReadingService smartReadingService;

    @GetMapping("/list")
    public ResponseEntity<List<SmartReading>> getSmartReadingList(){
        log.info("HTTP GET --> retrieveFunderTypes -->  /firebase/url");
        return ResponseEntity.ok(smartReadingService.listSmartReadings());
    }

    @GetMapping("/add")
    public ResponseEntity addSmartReading(SmartReading smartReading){
        log.info("HTTP GET --> retrieveFunderTypes -->  /firebase/url");
        return ResponseEntity.ok(smartReadingService.addSmartReading(smartReading));
    }
}