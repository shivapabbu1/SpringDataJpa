package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.Entity.Customer;
import com.demo.Entity.Item;
import com.demo.Repo.CustomerRepo;



@SpringBootApplication
public class SdjManyToManyBiDirectionalApplication  implements CommandLineRunner{

	@Autowired
	private CustomerRepo customerRepo;
	public static void main(String[] args) {
		SpringApplication.run(SdjManyToManyBiDirectionalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1= new Customer("kelevn");
		Customer c2= new Customer("jara");
		Customer c3= new Customer("eleven");
		
		Item i1=new Item("macbook");
		Item i2=new Item("skullcandy");
		Item i3=new Item("JBL");
		Item i4=new Item("Charger");
		Item i5=new Item("phoneCover");
		Item i6=new Item("bluetooth");
		
		c1.getItems().add(i1);
		c1.getItems().add(i2);
		c2.getItems().add(i5);
		c2.getItems().add(i6);
		c3.getItems().add(i3);
		c3.getItems().add(i4);
		
		customerRepo.save(c1);
		customerRepo.save(c2);
		customerRepo.save(c3);
	}
	

}
