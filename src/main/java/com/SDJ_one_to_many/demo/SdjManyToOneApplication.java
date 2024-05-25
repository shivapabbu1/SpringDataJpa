package com.SDJ_one_to_many.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SDJ_one_to_many.demo.Entity.Employee;
import com.SDJ_one_to_many.demo.Entity.Task;
import com.SDJ_one_to_many.demo.Repo.EmployeeRepo;

@SpringBootApplication
public class SdjManyToOneApplication  implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(SdjManyToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Employee e1 = new Employee("patcummins");
		    Employee e2 = new Employee("Bhuvi");
		    Employee e3 = new Employee("Raj");
		    Employee e4 = new Employee("Karan");
		    Employee e5 = new Employee("kushal");

		    Task t1 = new Task("UI Issue");
		  

		    e1.setTask(t1); // Assign task t1 to employee e1
		    e2.setTask(t1); // Assign task t2 to employee e2
		    e3.setTask(t1); // Assign task t1 to employee e3
		    
		    
		    employeeRepo.save(e1);
		    employeeRepo.save(e2);
		    employeeRepo.save(e3);
		  
		
	}

}
