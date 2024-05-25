package com.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.demo.service.CustomerService;
import com.demo.Entity.Customer;

import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/customers")
@Validated
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Validated
    @PostMapping("/save")
    public ResponseEntity<Customer> createCustomer( @Valid @RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>>getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomerById(@RequestBody Customer customer) {
        System.out.println("Received request to update customer with ID: " + customer.getId());
        Customer updatecustomer = customerService.updateCustomerById(customer);
        System.out.println("Returning updated customer with ID: " + updatecustomer.getId());


        return new ResponseEntity<>(updatecustomer, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable Long id) {
        String msg = customerService.deleteCustomer(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }
}

