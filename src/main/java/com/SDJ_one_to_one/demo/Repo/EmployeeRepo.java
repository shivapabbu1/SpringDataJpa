package com.SDJ_one_to_one.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SDJ_one_to_one.demo.Entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
