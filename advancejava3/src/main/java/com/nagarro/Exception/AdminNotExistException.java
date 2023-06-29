package com.nagarro.Exception;

public class AdminNotExistException extends RuntimeException {
	String message;

	public AdminNotExistException(String message) {
		this.message = message;
	}

	public String toString() {
		return "AdminNotExistException exception raised at line " + this.getStackTrace()[1].getLineNumber()
				+ " and at line " + this.getStackTrace()[0].getLineNumber() + " : '" + message + "'";
	}

}
