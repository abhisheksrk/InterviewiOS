package com.interview.example.exception;

public class ManufacturerNotExistException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ManufacturerNotExistException(String message) {
		super(message);
	}

}
