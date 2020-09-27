package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.Customer;
import com.dinitha.testapp.repository.CustomerRepository;
import com.dinitha.testapp.rest.CustomerController;
import com.google.cloud.language.v1.Document;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.google.cloud.language.v1.Sentiment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }


}
