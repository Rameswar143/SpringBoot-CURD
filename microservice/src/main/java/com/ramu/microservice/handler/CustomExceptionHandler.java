package com.ramu.microservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ramu.microservice.exception.BookNotFoundexception;
import com.ramu.microservice.exception.EmployeeNotFoundexception;
import com.ramu.microservice.exception.UserNotFoundException;

/**
 * @author PRAMESWA
 *
 */
@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundexception.class)
	public ResponseEntity<String> employeeNotFound(EmployeeNotFoundexception enfe) {
		return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(BookNotFoundexception.class)
	public ResponseEntity<String> employeeNotFound(BookNotFoundexception bnfe) {
		return new ResponseEntity<>(bnfe.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotFound(UserNotFoundException unf) {
		return new ResponseEntity<>(unf.getMessage(), HttpStatus.NOT_FOUND);
	}
}
