package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
