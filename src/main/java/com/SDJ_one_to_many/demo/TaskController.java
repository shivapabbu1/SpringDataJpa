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
public class TaskController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private TaskRepo taskRepo;

	@PostMapping("/tasks")
	public ResponseEntity<Task> createEmployee(@RequestBody Task task) {
		Task savedTask = taskRepo.save(task);
		return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
	}


	@PostMapping("/{empid}/assign")
	public ResponseEntity<List<Task>> assignTasks(@PathVariable int empid, @RequestBody List<Task> tasks) {
	    Employee employee = employeeRepo.findById(empid).orElse(null);
	    if (employee != null) {
	        for (Task task : tasks) {
	            task.setEmployee(employee);
	            employee.getTasks().add(task);
	            taskRepo.save(task);
	        }
	        employeeRepo.save(employee);
	        return new ResponseEntity<>(tasks, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}


}