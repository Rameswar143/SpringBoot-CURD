package com.ramu.microservice.exception;

/**
 * @author PRAMESWA
 *
 */
public class BookNotFoundexception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BookNotFoundexception() {
		super();
	}

	public BookNotFoundexception(String message) {
		super(message);
	}

}
