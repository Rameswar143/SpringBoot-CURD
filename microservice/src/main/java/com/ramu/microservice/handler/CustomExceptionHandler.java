package com.ramu.microservice.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ramu.microservice.exception.EmployeeNotFoundexception;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(EmployeeNotFoundexception.class)
	public ResponseEntity<String> getAllEmployees(EmployeeNotFoundexception enfe) {
		return new ResponseEntity<>(enfe.getMessage(), HttpStatus.NOT_FOUND);
	}
}
