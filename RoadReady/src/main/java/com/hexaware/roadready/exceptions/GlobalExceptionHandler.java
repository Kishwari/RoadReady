package com.hexaware.roadready.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<String> CustomerNotFound(Exception e) {
		return new ResponseEntity<String>(e.toString(),HttpStatus.NOT_FOUND);
	}
}
