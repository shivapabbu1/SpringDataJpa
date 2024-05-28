package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Entity.Account;
import com.demo.repo.AccountRepo;

import jakarta.transaction.Transactional;
@Service
public class BankService {
	
	@Autowired
	private AccountRepo accountRepo;
	
	

    public String createAcc(Account account) {
        accountRepo.save(account);
        return "Account created successfully";
    }

    @Transactional
    public void transferFunds(Long senderAccountId, Long recipientAccountId, double amount) {
        // Load sender and recipient accounts from database
        Account senderAccount = accountRepo.findById(senderAccountId).orElseThrow(() -> new RuntimeException("Sender account not found"));
        Account recipientAccount = accountRepo.findById(recipientAccountId).orElseThrow(() -> new RuntimeException("Recipient account not found"));

        // Deduct amount from sender's account
        senderAccount.setBalance(senderAccount.getBalance() - amount);

        // Credit amount to recipient's account
        recipientAccount.setBalance(recipientAccount.getBalance() + amount);

        // Update accounts in the database
        accountRepo.save(senderAccount);
        accountRepo.save(recipientAccount);
    }

}
