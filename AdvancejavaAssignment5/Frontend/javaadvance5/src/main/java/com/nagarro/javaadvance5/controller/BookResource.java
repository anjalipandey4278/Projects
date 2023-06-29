package com.nagarro.javaadvance5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.javaadvance5.model.Author;
import com.nagarro.javaadvance5.model.Book;
import com.nagarro.javaadvance5.services.AuthorService;
import com.nagarro.javaadvance5.services.BookService;

@RestController
public class BookResource {
	
	@Autowired
	private BookService bookservice;
	
	@Autowired
	public void setUserService(BookService bookservice) {
		this.bookservice = bookservice;
	}
	

	@GetMapping("/books")
	public List<Book> getAllData() {
		return bookservice.getAllData();
	}

	@GetMapping("/books/{id}")
	public Book getDatabyID(@PathVariable Long id) {
		return bookservice.getDatabyId(id);
	}

	 @PostMapping("/books")
	public void addData(@RequestBody Book book) {
		bookservice.addData(book);
	}

	 @DeleteMapping("/books/{id}")
	public void deleteData(@PathVariable Long id) {
		bookservice.deleteData(id);
	}

	  @PutMapping("/books/{id}")
	public void updateData(@RequestBody Book book, @PathVariable Long id) {
		bookservice.updateData(book, id);
	}

}