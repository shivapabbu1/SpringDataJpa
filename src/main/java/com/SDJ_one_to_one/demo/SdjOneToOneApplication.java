package com.SDJ_one_to_one.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SDJ_one_to_one.demo.Entity.Employee;
import com.SDJ_one_to_one.demo.Entity.Task;
import com.SDJ_one_to_one.demo.Repo.EmployeeRepo;


@SpringBootApplication
public class SdjOneToOneApplication  implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(SdjOneToOneApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Employee emp1=new Employee("pabbu");
		Employee emp2=new Employee("kommu");
		
		Task t1=new Task("Backend issues");
		Task t2=new Task("frontend issues");
		
		emp1.setTask(t2);
		emp2.setTask(t1);
		
		employeeRepo.save(emp1);
		employeeRepo.save(emp2);
		
	}




}
