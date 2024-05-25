package com.SDJ_one_to_many.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SDJ_one_to_many.demo.*;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
