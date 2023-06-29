package com.nagarro.springassignment.model;

public class Product {

 	public Product() {
	super();
	// TODO Auto-generated constructor stub
}
	public Long bookCode;
    public String bookName;
    public String bookAuthor;
    public String dateTime;

    

    
    public Product(Long bookCode, String bookName, String bookAuthor, String dateTime) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.dateTime = dateTime;
	}
	
	public Long getbookCode() {
    	return bookCode;
    }
    public String getbookName() {
    	return bookName;
    }
    public String getbookAuthor() {
    	return bookAuthor;
    }
    public String getdateTime() {
    	return dateTime;
    }
}
