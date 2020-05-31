package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.StatusEnum;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.backend.entity.UserData;

import java.util.ArrayList;
import java.util.List;

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
    private ProjectController projectController;
    private UserDataController userDataController;
    private UserSessionController usc;
    private TicketController tc;
	@Id("todoWrapper")
	private VerticalLayout todoWrapper;
	@Id("progressWrapper")
	private VerticalLayout progressWrapper;
	@Id("completedWrapper")
	private VerticalLayout completedWrapper;

    /**
     * Creates a new TicketsByStatus.
     */
    public TicketsByStatus(ProjectController projectController, UserDataController userDataController,
    UserSessionController usc, TicketController tc) {
        // You can initialise any data required for the connected UI components here.
    	this.projectController = projectController;
    	this.userDataController = userDataController;
    	this.usc = usc;
    	this.tc = tc;
    	testTickets();
    }

    public void testTickets()
    {
        List<Ticket> t = tc.findTicketsByPid(usc.getPid());
        for(Ticket ticket : t)
            Notification.show(ticket.getTitle());
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
      //filling in tickets based on db calls
        List<TicketComponent> ticketComponents = projectController.buildTicketComponents();
        //tickets = projectController.findPid(usc.getPid()).getTickets();
        for (TicketComponent tc : ticketComponents)
        {
            if (tc.getStatus() == "to do")
                todoWrapper.add(tc);
            if (tc.getStatus() == "in progress")
                progressWrapper.add(tc);
            if (tc.getStatus() == "done")
                completedWrapper.add(tc);
        }
    }
//    public TicketComponent generateTicketComponent(Ticket ticket) {
//        TicketComponent ticketComponent = new TicketComponent();
////        This will only hold one for the list as of right now
//        
//        for (String assignee:
//                ticket.getAssignees()) {
//        	UserData curr = userDataController.getFromEmail(assignee);
//            ticketComponent.setAssignedUser(curr.getEmail());
//        }
//        ticketComponent.setAssignedUser(ticket.getAssignees().get(0));
//        ticketComponent.setTitle(ticket.getTitle());
//        return ticketComponent;
//    }

}
