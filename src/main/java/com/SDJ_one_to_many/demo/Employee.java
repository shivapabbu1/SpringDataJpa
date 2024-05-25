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
@Table(name = "emp_mtob")
@Data
@NoArgsConstructor
@AllArgsConstructor
 public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;

    private String empname;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Task> tasks;
    
    
//
//    public Employee() {
//    }
//
//    public Employee(String empname) {
//        this.empname = empname;
//    }
//
//    public Employee(String empname, List<Task> tasks) {
//        this.empname = empname;
//        this.tasks = tasks;
//        for (Task task : tasks) {
//            task.setEmployee(this); // Ensure bidirectional relationship
//        }
//    }
//
//    public int getEmpid() {
//        return empid;
//    }
//
//    public void setEmpid(int empid) {
//        this.empid = empid;
//    }
//
//    public String getEmpname() {
//        return empname;
//    }
//
//    public void setEmpname(String empname) {
//        this.empname = empname;
//    }
//
//    public List<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(List<Task> tasks) {
//        this.tasks = tasks;
//        for (Task task : tasks) {
//            task.setEmployee(this); // Ensure bidirectional relationship
//        }
//    }
   
}
