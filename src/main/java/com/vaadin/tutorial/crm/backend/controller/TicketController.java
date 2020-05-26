package com.vaadin.tutorial.crm.backend.controller;

import com.vaadin.tutorial.crm.backend.entity.Database;
import com.vaadin.tutorial.crm.backend.entity.Ticket;

public class TicketController {
	
	private Ticket currentTicket;
	
	
	public static Ticket getNewTicket(String name){
		//TODO: Make this work.
        // should query database and fill new ticket with boilerplate info from database

        Database db = Database.getInstance();

        Ticket ticket = new Ticket(name);
        ticket.setDescription("This is a test");

        db.update(ticket, "testdata");

        return ticket;
    }
	
	public void UpdateTicket(String reference){
        //boundary-facing method for accessing database info and updating info
		//TODO: this needs to be fixed

        //query database for info
        Database db = Database.getInstance();

        //fill a ticket
        Ticket ticket = getNewTicket(reference);


        //push data back to database
        //should return JSON to be passed to database method
	}

}
