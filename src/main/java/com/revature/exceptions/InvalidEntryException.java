package com.revature.exceptions;

public class InvalidEntryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidEntryException(String message) {
		super(message);
	}
}
