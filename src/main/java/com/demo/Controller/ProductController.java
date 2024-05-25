package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.demo.DTO.IProdcutDTO;
import com.demo.DTO.ProductDTO;
import com.demo.Entity.Product;
import com.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("create")
	public String create(@RequestBody Product product) {
		return  productService.createProduct(product);
	}
	@GetMapping("/products")
    public List<IProdcutDTO> getProductsByName(@RequestParam String name) {
        return productService.findProductsByName(name);
    }
	

}
