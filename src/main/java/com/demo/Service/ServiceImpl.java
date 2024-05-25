package com.demo.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.Entity.Product;
import com.demo.Reposistory.ProductReposistory;

@Service
public class ServiceImpl implements ProductService{

	@Autowired
	private ProductReposistory reposistory;
	
	@Override
	public Product saveProduct(Product product) {
		
		return reposistory.save(product);
	}

	@Override
	public List<Product> getProduct(String name) {
		return  reposistory.findByName(name);
	}

	  public List<Product> findByNameAndPrice(String name, Integer price) {
			return reposistory.findByNameAndPrice(name, price);
		}

	  @Override
	    public Page<Product> findAll(Pageable pageable) {
	        return reposistory.findAll(pageable);
	    }

	@Override
	public List<Product> findByPriceLessThan(Integer price, Sort sort) {
		 return reposistory.findByPriceLessThan(price,sort);
	}

	  


	    

}
