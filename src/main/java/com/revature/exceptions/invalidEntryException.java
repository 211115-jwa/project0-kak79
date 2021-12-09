package com.revature.exceptions;

public class invalidEntryException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public invalidEntryException(String message) {
		super(message);
	}
}
