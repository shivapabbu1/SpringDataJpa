package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.demo.repo.CustomerRepo;

import jakarta.transaction.Transactional;

import com.demo.Entity.Customer;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {

    @Autowired
    private CustomerRepo repo;

   
    public Customer saveCustomer( Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return repo.findAll();
    }

    @Cacheable(cacheNames = "customers" ,key="#id")
    public Optional<Customer> getCustomerById(Long id) {
    	System.out.println("Get Customer api calling MySql Database");
        return  repo.findById(id);   		
    }
    
    @CachePut(cacheNames = "customers", key = "#customer.id")
    public Customer updateCustomerById(Customer customer) {
        if (customer.getId() == null) {
            throw new IllegalArgumentException("Customer ID cannot be null");
        }
        System.out.println("put Customer api calling MySql Database for ID: " + customer.getId());
        return repo.save(customer);
    }
    
    @CacheEvict(cacheNames = "customers" ,key="#id")
    public String deleteCustomer(Long id) {
    	repo.deleteById(id);
    	return "Customer deleted ";
    }
    
}

