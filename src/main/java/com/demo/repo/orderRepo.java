package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Entity.OrderInfo;




public interface orderRepo extends JpaRepository<OrderInfo,Integer > {

}
