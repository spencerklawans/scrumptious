package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.entity.Ticket;

import java.util.ArrayList;

/**
 * A Designer generated component for the tickets-by-status template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("tickets-by-status")
@JsModule("./src/views/tickets-by-status.js")
public class TicketsByStatus extends PolymerTemplate<TicketsByStatus.TicketsByStatusModel> {

    @Id("createButton")
	private Button createButton;
    private TicketController ticketController = new TicketController();
    @Id("todo")
    private VerticalLayout todo;
    @Id("inProgress")
    private VerticalLayout inProgress;
    @Id("completed")
    private VerticalLayout completed;

    /**
     * Creates a new TicketsByStatus.
     */
    public TicketsByStatus() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between TicketsByStatus and tickets-by-status
     */
    public interface TicketsByStatusModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	createButton.addClickListener(e ->
    		createButton.getUI().ifPresent(ui -> ui.navigate("create-ticket"))
    	);
    }
    public void populateTickets() {
////      filling in tickets based on db calls
//        ArrayList<Ticket> todoTickets = ticketController.getTickets("todo", this_project);
//        for (Ticket ticket : todoTickets) {
//            todo.add(ticket);
//        }
//        ArrayList<Ticket> inProgressTickets = ticketController.getTickets("inProgress", this_project);
//        for (Ticket ticket : inProgressTickets) {
//            todo.add(ticket);
//        }
//        ArrayList<Ticket> completedTickets = ticketController.getTickets("completed", this_project);
//        for (Ticket ticket : completedTickets) {
//            todo.add(ticket);
//        }
    }
}
