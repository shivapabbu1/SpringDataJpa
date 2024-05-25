package com.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Product;
import com.demo.Service.ServiceImpl;

@RestController
@RequestMapping("Product")
public class ProductController {
   @Autowired
   private ServiceImpl serviceImpl;
	
   @GetMapping("/getAllProducts")
   public ResponseEntity<Page<Product>> getAllProducts(@RequestParam int page, @RequestParam int size) {
       Pageable pageable = PageRequest.of(page, size);
       Page<Product> products = serviceImpl.findAll(pageable);
       return ResponseEntity.ok(products);
   }
   
   @PostMapping("/saveProduct")
   public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
       Product savedProduct = serviceImpl.saveProduct(product);
       return ResponseEntity.ok(savedProduct);
   }
   
   @GetMapping("/getProduct/{name}")
   public ResponseEntity<List<Product>> getProduct(@PathVariable String name) {
       List<Product> products = serviceImpl.getProduct(name);
       return ResponseEntity.ok(products);
   }
   @GetMapping("/getProductByNameAndPrice")
   public ResponseEntity<List<Product>> getProductByNameAndPrice(@RequestParam String name, @RequestParam Integer price) {
       List<Product> products = serviceImpl.findByNameAndPrice(name,price);
       return ResponseEntity.ok(products);
   }
   
   @GetMapping("/getByPriceLessThan")
   public ResponseEntity<List<Product>> getByPriceLessThan(
           @RequestParam Integer price,
           
           @RequestParam(defaultValue = "id") String sortBy,
           @RequestParam(defaultValue = "asc") String sortDirection) {

       Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
     
       List<Product> products = serviceImpl.findByPriceLessThan(price,sort);
       return ResponseEntity.ok(products);
   }


  
}
