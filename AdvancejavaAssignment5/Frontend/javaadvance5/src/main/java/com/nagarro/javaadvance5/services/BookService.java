package com.nagarro.javaadvance5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.javaadvance5.exception.BookNotFoundException;
import com.nagarro.javaadvance5.model.Book;
import com.nagarro.javaadvance5.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookrepository;

	public List<Book> getAllData() {
		List<Book> data = new ArrayList<>();
		bookrepository.findAll().forEach(data::add);
		System.out.print(data);
		return data;
	}

	public Book getDatabyId(Long id) {
		 Optional<Book> book = bookrepository.findById(id);
		 if (book.isEmpty())
	            throw new BookNotFoundException("id-" + id);

	       
		return bookrepository.findById(id).get();
	}

	public void deleteData(Long id) {
		bookrepository.findById(id).ifPresent(bookrepository::delete);

	}

	public void addData(Book book) {
		bookrepository.save(book);
	}

	public void updateData(Book book, Long id) {
		 Optional<Book> bookop = bookrepository.findById(id);
		 if (bookop.isEmpty()) {
			 throw new BookNotFoundException("id-" + id);
		 }
		book.setBookCode(id);
		bookrepository.save(book);

	}

}