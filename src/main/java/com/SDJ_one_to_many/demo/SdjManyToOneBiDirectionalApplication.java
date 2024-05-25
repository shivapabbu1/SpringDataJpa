package com.SDJ_one_to_many.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SDJ_one_to_many.demo.Repo.EmployeeRepo;
import com.SDJ_one_to_many.demo.Repo.TaskRepo;

@SpringBootApplication
public class SdjManyToOneBiDirectionalApplication  {

	
	public static void main(String[] args) {
		SpringApplication.run(SdjManyToOneBiDirectionalApplication.class, args);
	}

	

}
