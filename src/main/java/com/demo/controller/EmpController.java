package com.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Entity.Book;

import com.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("employee")
public class EmpController {
	@Autowired
	private EmployeeService service;
	
	@PostMapping("save")
	public String saveBook(@RequestBody Book book ) {
		return service.saveBook(book);
	}
	
	@PutMapping("update/{id}/{pages}")
	public String updateBook(@PathVariable int id,@PathVariable String pages) {
		
		return service.updateBook(id, pages);
	}
	@DeleteMapping("delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return service.deleteBook(id);
	}
	
	@GetMapping("getinfo/{id}")
	public void getMethodName(@PathVariable int id) {
		System.out.println(service.getInfo(id)); 
	}
	
	@GetMapping("getrevinfo/{id}")
	public void getRevInfo(@PathVariable int id) {
		System.out.println( service.findRevisions(id));
	}
	

    @GetMapping("/{id}/revision")
    public String getRevisionByNumber(@PathVariable int id,@RequestParam int revisionNumber ) {
        Optional<Revision<Integer, Book>> revision = service.findRevisionByRevisionNumber(id, revisionNumber);
        return revision.map(rev -> "Revision found: " + rev).orElse("Revision not found");
    }

    

	
	
	
	

}
