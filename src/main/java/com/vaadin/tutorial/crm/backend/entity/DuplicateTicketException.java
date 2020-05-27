package com.vaadin.tutorial.crm.backend.entity;

public class DuplicateTicketException extends Exception{
	
	private static final String EXCEPTION_MESSAGE = "A Ticket with the same name already exists: ";

	public DuplicateTicketException(String msg) {
		// TODO Auto-generated constructor stub
		super(EXCEPTION_MESSAGE + msg);
	}
}