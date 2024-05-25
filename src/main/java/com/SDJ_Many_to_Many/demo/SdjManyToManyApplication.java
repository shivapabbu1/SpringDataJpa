package com.SDJ_Many_to_Many.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.SDJ_Many_to_Many.demo.Entity.Customer;
import com.SDJ_Many_to_Many.demo.Entity.Item;
import com.SDJ_Many_to_Many.demo.Repo.CustomerRepo;

@SpringBootApplication
public class SdjManyToManyApplication implements CommandLineRunner{

	@Autowired
	private CustomerRepo repo;
	public static void main(String[] args) {
		SpringApplication.run(SdjManyToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1= new Customer("Raju");
		Customer c2= new Customer("Ramana");
		Customer c3= new Customer("kishore");
		
		Item i1=new Item("laptop");
		Item i2=new Item("mobile");
		Item i3=new Item("ipad");
		Item i4=new Item("earpones");
		Item i5=new Item("desktop");
		Item i6=new Item("keyboard");
		
		c1.getItems().add(i1);
		c1.getItems().add(i2);
		c2.getItems().add(i5);
		c2.getItems().add(i6);
		c3.getItems().add(i3);
		c3.getItems().add(i4);
		
		repo.save(c1);repo.save(c2);repo.save(c3);
	}

}
