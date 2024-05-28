package com.demo.controller;

import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Account;
import com.demo.dto.Request;
import com.demo.service.BankService;
@RestController
public class BankController {
	
	@Autowired
    private BankService bankService;
	
	
	@PostMapping("/create")
		public String  createAccount(@RequestBody Account account) {
			return bankService.createAcc(account);
		}
	

    @PostMapping("/transfer")
    public String transferFunds(@RequestBody Request request) {
      
            bankService.transferFunds(request.getSenderAccountId(), request.getRecipientAccountId(), request.getAmount());
            return "Funds transferred successfully";
       
    }

}
