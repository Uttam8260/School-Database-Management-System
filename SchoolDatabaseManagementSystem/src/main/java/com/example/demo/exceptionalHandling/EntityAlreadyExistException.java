package com.example.demo.exceptionalHandling;

public class EntityAlreadyExistException extends RuntimeException {

	public EntityAlreadyExistException(String msg) {
		super(msg);
	}
}
