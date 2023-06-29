package com.nagarro.javaadvance5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.javaadvance5.exception.BookNotFoundException;
import com.nagarro.javaadvance5.model.Author;

import com.nagarro.javaadvance5.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorrepository;
	
	public List<Author> getAllAuthorData() {
		List<Author> data = new ArrayList<>();
		authorrepository.findAll().forEach(data::add);
		System.out.print(data);
		return data;
	}
	public Author getDatabyId(long id) {
		 Optional<Author> author = authorrepository.findById(id);
		 if (author.isEmpty())
	            throw new BookNotFoundException("id-" + id);
        return authorrepository.findById(id).get();
	}
	public void addData(Author author) {
		authorrepository.save(author);
	}

}
