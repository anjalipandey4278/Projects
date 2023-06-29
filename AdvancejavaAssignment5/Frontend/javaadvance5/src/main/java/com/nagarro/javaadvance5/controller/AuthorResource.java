package com.nagarro.javaadvance5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.javaadvance5.model.Author;
import com.nagarro.javaadvance5.services.AuthorService;



@RestController
public class AuthorResource {
	
	@Autowired
	private AuthorService authorservice;


	
	@GetMapping("/author")
	public List<Author> getAllData() {
		return authorservice.getAllAuthorData();
	}
	
	 @PostMapping("/author")
	public void addData(@RequestBody Author author) {
		 authorservice.addData(author);
	}


}
