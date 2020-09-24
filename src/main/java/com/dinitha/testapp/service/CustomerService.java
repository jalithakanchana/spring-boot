package com.dinitha.testapp.service;

import com.dinitha.testapp.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {
    List<Customer> listCustomers();
}
