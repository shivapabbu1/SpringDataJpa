package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

import com.demo.Entity.PaymentInfo;
import com.demo.exception.CustomException;
import com.demo.repo.PayementRepo;

import org.springframework.transaction.annotation.Transactional;

@Service
public class PayemntService {
    
    @Autowired
private PayementRepo payementRepo;   
    @Transactional(
            propagation = Propagation.REQUIRES_NEW
                                   
    )
    public void savePayment(PaymentInfo paymentInfo) {
    	payementRepo.save(paymentInfo);
    }
}