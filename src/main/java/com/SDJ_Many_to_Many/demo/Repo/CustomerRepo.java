package com.SDJ_Many_to_Many.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SDJ_Many_to_Many.demo.Entity.Customer;

public interface CustomerRepo  extends JpaRepository<Customer, Integer>{

}
