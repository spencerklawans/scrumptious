package com.vaadin.tutorial.crm.backend.entity;

public class DuplicateProjectException extends Exception{
	
	final private static String exceptionMessage = "A Project with the same name already exists: ";
	
	public DuplicateProjectException(String msg) {
		// Custom Exception for Duplicate Projects
		super(exceptionMessage + msg);
	}
}
