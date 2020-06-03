package com.scrumptious.logic.backend.entity;

public class DuplicateProjectException extends Exception{
	
	private static final String EXCEPTION_MESSAGE = "A Project with the same name already exists: ";
	
	public DuplicateProjectException(String msg) {
		super(EXCEPTION_MESSAGE + msg);
	}
}
