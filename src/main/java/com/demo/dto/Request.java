package com.demo.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
	
	   private Long senderAccountId;
	    private Long recipientAccountId;
	    private double amount;
}
