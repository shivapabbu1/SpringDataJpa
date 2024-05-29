package com.demo.Entity;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String loginUser;
	private String name;

	private String dept;

	private Double salary;

	@CreatedBy
    private String createdBy;
	
	@CreatedDate
	private Date createdDate;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	private LocalDateTime lastModifiedDate;
	
	
}
