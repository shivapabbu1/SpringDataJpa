package com.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="task")

public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskid;
	
	private String taskname;
	
	@OneToOne
    @JoinColumn(name = "empid")
    private Employee employee;
	

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Task(String taskname) {
		super();
		this.taskname = taskname;
	}
	
	

}
