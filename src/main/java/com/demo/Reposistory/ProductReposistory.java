package com.demo.Reposistory;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.Entity.Product;

@Repository
public interface ProductReposistory extends JpaRepository<Product, Integer> {
	   // Derived query method
    // List<Product> findByName(String name); 
	 
   // Method using @Query annotation for various use cases
	
	
    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> findByName(@Param("name") String name);
    
    @Query("SELECT p FROM Product p WHERE p.name = :name AND p.price = :price")
    List<Product> findByNameAndPrice(@Param("name") String name, @Param("price") Integer price);


    @Query("SELECT p FROM Product p WHERE  p.price < :price")
    List<Product> findByPriceLessThan(@Param("price") Integer price ,Sort sort );
    
    
    

  


}
