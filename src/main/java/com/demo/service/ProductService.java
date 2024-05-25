package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.DTO.IProdcutDTO;
import com.demo.Entity.Product;
import com.demo.repo.ProductRepo;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;
	
	public String createProduct(Product product) {
		repo.save(product);
		return "Product saved sucessfully";
	}
	
	public List<IProdcutDTO> findProductsByName(String name) {
        
        return repo.findByName(name);
    }

}
