package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.Entity.PaymentInfo;

public interface  PayementRepo extends JpaRepository<PaymentInfo, Long> {

}
