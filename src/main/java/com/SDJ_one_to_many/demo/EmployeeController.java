package com.SDJ_one_to_many.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.SDJ_one_to_many.demo.Entity.Employee;
import com.SDJ_one_to_many.demo.Entity.Task;
import com.SDJ_one_to_many.demo.Repo.EmployeeRepo;
import com.SDJ_one_to_many.demo.Repo.TaskRepo;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo ;

    @Autowired
    private  TaskRepo taskRepo;

    // Endpoint to save an employee along with their tasks
    @PostMapping("/employees")
  public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeRepo.save(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    
}
