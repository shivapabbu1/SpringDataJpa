package com.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.DTO.IProdcutDTO;
import com.demo.Entity.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
	
	
    List<IProdcutDTO> findByName( String name);
	   
}
