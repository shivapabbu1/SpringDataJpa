package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.Entity.OrderInfo;
import com.demo.Entity.PaymentInfo;
import com.demo.dto.OrderAck;
import com.demo.dto.OrderRequest;
import com.demo.exception.CustomException;
import com.demo.repo.PayementRepo;
import com.demo.repo.orderRepo;
import static com.demo.util.PaymentValidation.validatePaymentInfo;
@Service
public class OrderService {

	@Autowired
	private orderRepo orderRepo;

	@Autowired
	private PayementRepo payementRepo;

	

	@Transactional(
		    propagation = Propagation.REQUIRED, // Default propagation behavior
		    isolation = Isolation.DEFAULT,      // Default isolation level
		    rollbackFor = {CustomException.class},     // Roll back for all exceptions by default
		    timeout = 60,                       // Transaction timeout in seconds
		    readOnly = false                    // Read-write transaction by default
		)

	public OrderAck placingOrder(OrderRequest orderRequest) {
		OrderInfo orderInfo = orderRequest.getOrderInfo();
		orderInfo = orderRepo.save(orderInfo);

		PaymentInfo paymentInfo = orderRequest.getPaymentInfo();
		validatePaymentInfo(paymentInfo);
		orderInfo.setProductName(paymentInfo.getProductName());
		orderRepo.save(orderInfo);
		payementRepo.save(paymentInfo);
		return new OrderAck("Success", paymentInfo.getAmount(), paymentInfo);
	}


}


/*
 *  Propagation.REQUIRED: If a transaction exists, use it. Otherwise, start a new transaction.
Propagation.REQUIRES_NEW: Always start a new transaction, suspending the current transaction if one exists.
Propagation.SUPPORTS: If a transaction exists, use it. Otherwise, execute non-transactionally.
Propagation.NOT_SUPPORTED: Execute non-transactionally, suspending the current transaction if one exists.
Propagation.MANDATORY: If a transaction exists, use it. Otherwise, throw an exception.
Propagation.NEVER: Execute non-transactionally, throwing an exception if a transaction exists.
Propagation.NESTED: Execute within a nested transaction if a current transaction exists, otherwise start a new transaction.
Isolation Levels:
Isolation.DEFAULT: Use the default isolation level of the underlying database.
Isolation.READ_UNCOMMITTED: Allows dirty reads, non-repeatable reads, and phantom reads.
Isolation.READ_COMMITTED: Prevents dirty reads, allowing non-repeatable reads and phantom reads.
Isolation.REPEATABLE_READ: Prevents dirty reads and non-repeatable reads, allowing phantom reads.
Isolation.SERIALIZABLE: Prevents dirty reads, non-repeatable reads, and phantom reads, providing the highest level of isolation
 * 
 * 
 * 
 * 
 * 
 * 
 * */
 