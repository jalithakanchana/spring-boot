package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.SmartReading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SmartReadingService {
    List<SmartReading> listSmartReadings();

    List<SmartReading> addSmartReading(SmartReading smartReading);
}
