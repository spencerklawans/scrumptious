package com.scrumptious.logic.backend.entity;

public class DuplicateTicketException extends Exception{
	
	private static final String EXCEPTION_MESSAGE = "A Ticket with the same name already exists: ";

	public DuplicateTicketException(String msg) {
		super(EXCEPTION_MESSAGE + msg);
	}
}