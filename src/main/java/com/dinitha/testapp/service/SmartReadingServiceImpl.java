package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.SmartReading;
import com.dinitha.testapp.repository.SmartReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartReadingServiceImpl implements SmartReadingService  {
    @Autowired
    private SmartReadingRepository smartReadingRepository;

    @Override
    public List<SmartReading> listSmartReadings() {
        return smartReadingRepository.findAll();
    }

    @Override
    public List<SmartReading> addSmartReading(SmartReading smartReading) {
        smartReadingRepository.save(smartReading);
        return (List<SmartReading>) smartReading;
    }
}
