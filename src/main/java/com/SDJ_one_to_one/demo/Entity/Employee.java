package com.SDJ_one_to_one.demo.Entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="emp_oto")

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
