package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Employee;
import com.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	public String saveEmployee(Employee employee) {
		String CurrentUser=employee.getLoginUser();
		employee.setCreatedBy(CurrentUser);
		repo.save(employee);
		return "Saved Employee";
	}
	
	public String updateEmployee(int id,double salary,Employee employee) {
		Employee getEmp=repo.findById(id).get();
		if(getEmp !=null) {
			employee.setSalary(salary);
			employee.setLastModifiedBy(employee.getLoginUser());
			repo.saveAndFlush(employee);
		}else {
			throw new  RuntimeException ("Emp not found by id:"+ id);
		}
		return "Updated employee";
	}

}
