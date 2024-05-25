package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.Entity.Employee;
import com.demo.Entity.Task;
import com.demo.Repo.EmployeeRepo;

@SpringBootApplication
public class SdjOneToOneBiDirectionalApplication implements CommandLineRunner {

	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(SdjOneToOneBiDirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Employee emp1 = new Employee("Shivaprasad");
        Employee emp2 = new Employee("Kirankumar");

        Task t1 = new Task("Backend issues complete");
        Task t2 = new Task("Frontend issues complete");

        emp1.setTask(t1);
        emp2.setTask(t2);

        t1.setEmployee(emp1);
        t2.setEmployee(emp2);

        employeeRepo.save(emp1);
        employeeRepo.save(emp2);
		
	}

}
