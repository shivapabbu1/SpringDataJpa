package com.SDJ_one_to_many.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SDJ_one_to_many.demo.Entity.Employee;
import com.SDJ_one_to_many.demo.Entity.Task;
import com.SDJ_one_to_many.demo.Repo.EmployeeRepo;

@SpringBootApplication
public class SdjOneToManyApplication  implements CommandLineRunner{

	
	@Autowired
	private EmployeeRepo employeeRepo;
	public static void main(String[] args) {
		SpringApplication.run(SdjOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee e1=new Employee("patcummins");
		Employee e2=new Employee("Bhuvi");
		
		Task t1=new Task("UI Issue");
		Task t2=new Task("Testing Issue");
		Task t3=new Task("Operations Issue");
		Task t4=new Task("Registration Issue");
		Task t5=new Task("Login Issue");
		
		e1.getTasks().add(t1);
		e1.getTasks().add(t3);
		e2.getTasks().add(t2);
		e2.getTasks().add(t4);
		e1.getTasks().add(t5);
		
		employeeRepo.save(e1);
		employeeRepo.save(e2);
		
	}

}
