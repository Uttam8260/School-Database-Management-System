package com.example.demo.exceptionalHandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.utility.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	
	@ExceptionHandler(EntityAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityAlreadyExistsException(EntityAlreadyExistException e){
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.CONFLICT.value(), e.getMessage(), null, LocalDateTime.now());
		return new ResponseEntity<>(structure, HttpStatus.CONFLICT);
		
	}
	@ExceptionHandler(EntityNotPresentException.class)
	public ResponseEntity<ResponseStructure<String>> handleEntityNotPresentException(EntityNotPresentException e){
		ResponseStructure<String> structure = new ResponseStructure<>(HttpStatus.NOT_FOUND.value(), e.getMessage(), null, LocalDateTime.now());
		return new ResponseEntity<>(structure, HttpStatus.NOT_FOUND);
	}
}
