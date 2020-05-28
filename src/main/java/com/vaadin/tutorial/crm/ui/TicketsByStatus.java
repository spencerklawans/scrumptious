package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.DatabaseController;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.backend.entity.User;

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
    @Id("todo")
    private VerticalLayout todo;
    @Id("inProgress")
    private VerticalLayout inProgress;
    @Id("completed")
    private VerticalLayout completed;
    private ProjectController projectController = new ProjectController();

    /**
     * Creates a new TicketsByStatus.
     */
    public TicketsByStatus(DatabaseController dbc) {
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
//      filling in tickets based on db calls
//        ArrayList<Ticket> todoTickets = projectController.getTickets("todo", this_project);
//        for (Ticket ticket : todoTickets) {
//            todo.add(ticket);
//        }
//        ArrayList<Ticket> inProgressTickets = projectController.getTickets("inProgress", this_project);
//        for (Ticket ticket : inProgressTickets) {
//            inProgress.add(ticket);
//        }
//        ArrayList<Ticket> completedTickets = projectController.getTickets("completed", this_project);
//        for (Ticket ticket : completedTickets) {
//            completed.add(ticket);
//        }
    }
    public TicketComponent generateTicketComponent(Ticket ticket) {
        TicketComponent ticketComponent = new TicketComponent();
//        This will only hold one for the list as of right now
        for (User assignee:
                ticket.getAssignees()) {
            ticketComponent.setAssignedUser(assignee.getFirstName());
        }
        ticketComponent.setAssignedUser(ticket.getAssignees().get(0).getFirstName());
        ticketComponent.setTitle(ticket.getTitle());
        return ticketComponent;
    }
}
