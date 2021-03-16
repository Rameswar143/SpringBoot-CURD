package com.ramu.microservice.exception;

public class EmployeeNotFoundexception extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundexception() {
		super();
	}

	public EmployeeNotFoundexception(String message) {
		super(message);
	}

}
