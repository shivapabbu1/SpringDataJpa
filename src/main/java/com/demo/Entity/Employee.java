package com.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="emp")

public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
	
	private String empname;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="taskid")

	 private Task task;
	
	public Employee(String empname) {
		super();
		this.empname = empname;
		
	}
	
	
	public void setTask(Task task) {
		this.task = task;
	}
}
	
	
	
	