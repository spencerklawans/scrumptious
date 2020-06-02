package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
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
        List<TicketComponent> ticketComponents = projectController.buildTicketComponents(usc.getPid());
        
        for (TicketComponent ticket : ticketComponents)
        {
            if (ticket.getStatus().equals("to do")) {
            	ticket.setPriority(e -> generatePopUp(ticket.getTicketNum()));
            	todoWrapper.add(ticket);
            }
            if (ticket.getStatus().equals("in progress")) {
            	ticket.setPriority(e -> generatePopUp(ticket.getTicketNum()));
            	progressWrapper.add(ticket);
            }
            if (ticket.getStatus().equals("done")) {
            	ticket.setPriority(e -> generatePopUp(ticket.getTicketNum()));
            	completedWrapper.add(ticket);
            }
        }
    }
    
    public void setWrapperStyle() {
    	todoWrapper.getStyle().set("overflow", "auto"); 
    	progressWrapper.getStyle().set("overflow", "auto"); 
    	completedWrapper.getStyle().set("overflow", "auto"); 
    }
    
    public void generatePopUp(int index) {
    	EditTicket et = new EditTicket(projectController, usc, userDataController); 
    	Long pid = usc.getPid(); 
    	Dialog dialog = new Dialog(); 
    	
    	et.setDates(tc.getDateAssigned(index, pid), tc.getDateDue(index, pid));
    	et.setTextDetails(tc.getTicketTitle(index, pid), tc.getTicketDescription(index, pid));
    	et.setPriority(tc.getPriority(index, pid));
    	et.setStatus(tc.getStatus(index, pid));
    	et.setAssignees(tc.getAssignees(index, pid));
    	
    	et.getCancelButton().addClickListener(e -> {
    		dialog.close(); 
    	}); 
    	
    	et.getUpdateButton().addClickListener(e -> {
    		tc.updateTicket(et.getTitle(), et.getDescription(), et.getDateDue(), 
    				et.getPriority(), et.getStatus(), et.getAssignees(), index, pid);
    		dialog.close(); 
    		UI.getCurrent().getPage().reload();
    	});
    	
    	dialog.add(et);
    	dialog.open(); 
    }

}
