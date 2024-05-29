package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


import com.demo.Entity.Customer;
import com.demo.repository.CustomerRepo;

import jakarta.validation.Valid;
import java.util.List;

@Service
@Validated
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    @Validated
    public Customer saveCustomer(@Valid Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    public Customer getCustomerById(Long id) {
        return repo.findById(id)
        		.orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}

