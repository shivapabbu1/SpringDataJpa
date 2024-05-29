package com.demo.repository;

import java.util.Optional;

import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;

import com.demo.Entity.Book;


public interface EmployeeRepo extends RevisionRepository<Book, Integer, Integer> ,JpaRepository<Book, Integer> {
	
	  




}
