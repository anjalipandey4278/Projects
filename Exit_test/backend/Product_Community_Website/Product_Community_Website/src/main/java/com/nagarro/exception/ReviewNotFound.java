package com.nagarro.exception;

public class ReviewNotFound extends RuntimeException {
	 public ReviewNotFound() {
	        super();
	    }


	    public ReviewNotFound(String message) {
	        super(message);
	    }


	    public ReviewNotFound(String message, Throwable cause) {
	        super(message, cause);
	    }
	    

}
