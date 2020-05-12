package com.vaadin.tutorial.crm.backend.entity;

public class DuplicateTicketException extends Exception{
	
	final private static String exceptionMessage = "A Ticket with the same name already exists: ";

	public DuplicateTicketException(String msg) {
		// TODO Auto-generated constructor stub
		super(exceptionMessage + msg);
	}
}