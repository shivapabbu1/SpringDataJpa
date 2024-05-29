package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("employee")
public class EmpController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("save")
	public String saveEmp(@RequestBody Employee employee ) {
		return service.saveEmployee(employee);
	}
	
	@PutMapping("update/{id}/{salary}")
	public String updateEmp(@PathVariable int id,@PathVariable double salary, @RequestBody Employee employee) {
		
		return service.updateEmployee(id, salary, employee);
	}
	

}
