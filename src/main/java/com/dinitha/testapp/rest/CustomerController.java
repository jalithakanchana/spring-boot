package com.dinitha.testapp.rest;

import com.dinitha.testapp.entity.Customer;
import com.dinitha.testapp.service.CustomerService;
import com.dinitha.testapp.utilities.SemanticAPI;
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
@RequestMapping("/v1/customer")
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SemanticAPI semanticAPI;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getCustomerList(){
        log.info("HTTP GET --> retrieveFunderTypes -->  /firebase/url");
        return ResponseEntity.ok(customerService.listCustomers());
    }





}
