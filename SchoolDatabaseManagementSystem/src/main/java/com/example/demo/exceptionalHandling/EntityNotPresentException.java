package com.example.demo.exceptionalHandling;

public class EntityNotPresentException extends RuntimeException {

	public EntityNotPresentException(String s) {
		super(s);
	}
}
