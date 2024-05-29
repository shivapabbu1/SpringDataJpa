package com.demo.service;

import java.util.Optional;

import org.hibernate.envers.RevisionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.stereotype.Service;

import com.demo.Entity.Book;

import com.demo.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;
	
	public String saveBook(Book book ) {
		
		repo.save(book);
		return "Saved book";
	}
	
	public String updateBook(int id,String pages) {
		Book book=repo.findById(id).get();
		if(book !=null) {
			book.setPages(pages);
	
			repo.save(book);
		}else {
			throw new  RuntimeException ("book not found by id:"+ id);
		}
		return "Updated book";
	}
	
	public String deleteBook(int id) {
		repo.deleteById(id);
		return "deleted book";
	}

	public Optional<Revision<Integer, Book>> getInfo(int id) {
		return repo.findLastChangeRevision(id);
			
	}
	
	public Revisions<Integer, Book> findRevisions( int id){
		return repo.findRevisions(id);
		
	}
	
	public Optional<Revision<Integer, Book>> findRevisionByRevisionNumber(int id, int revisionNumber) {
        return repo.findRevision(id, revisionNumber);
    }
	
    
	
   
    
    
}
