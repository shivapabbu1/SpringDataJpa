package com.SDJ_one_to_many.demo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task_mtob")
@Data


public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskid;

    private String taskname;


    @ManyToOne
    @JoinColumn(name = "empid") // Foreign key column to reference Employee
    private Employee employee;
    
    
    public Task() {
    }

    public Task(String taskname) {
        this.taskname = taskname;
    }

    public Task(String taskname, Employee employee) {
        this.taskname = taskname;
        this.employee = employee;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    
   
}
