package com.demo.dto;

import com.demo.Entity.OrderInfo;
import com.demo.Entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private OrderInfo orderInfo ;

    private PaymentInfo paymentInfo ;
}