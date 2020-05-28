package com.vaadin.tutorial.crm.backend.entity;

public class DuplicateProjectException extends Exception{
	
	private static final String EXCEPTION_MESSAGE = "A Project with the same name already exists: ";
	
	public DuplicateProjectException(String msg) {
		// Custom Exception for Duplicate Projects
		super(EXCEPTION_MESSAGE + msg);
	}
}
