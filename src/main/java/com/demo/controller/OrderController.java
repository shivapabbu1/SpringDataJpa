package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.OrderInfo;
import com.demo.dto.OrderAck;
import com.demo.dto.OrderRequest;
import com.demo.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {

     @Autowired
     private OrderService orderService;
     
     
     
     
     
   @PostMapping("/placeOrder")
    public OrderAck  placeOrder(@RequestBody OrderRequest orderRequest){
    return orderService.placingOrder(orderRequest)  ;
   }

}