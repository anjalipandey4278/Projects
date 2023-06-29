package com.nagarro.javaadvance5.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String exception) {
        super(exception);
    }

}