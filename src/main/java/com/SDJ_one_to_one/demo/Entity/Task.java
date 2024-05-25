package com.SDJ_one_to_one.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="task_oto")

public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int taskid;
	
	private String taskname;


	public Task(String taskname) {
		super();
		this.taskname = taskname;
	}
	
	

}
