package com.demo.Service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.demo.Entity.Product;

public interface ProductService {
	
     Product saveProduct(Product product);
     
     List<Product> getProduct(String name );
     List<Product> findByNameAndPrice(String name ,Integer price);
     List<Product> findByPriceLessThan(Integer price ,Sort sort);
     Page<Product> findAll(Pageable pageable);
     

	  
   
    
}
