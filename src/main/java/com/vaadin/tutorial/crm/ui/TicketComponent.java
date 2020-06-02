package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the ticket-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("ticket-component")
@JsModule("./src/views/ticket-component.js")
public class TicketComponent extends PolymerTemplate<TicketComponent.TicketComponentModel> {
	private static final String HIGH = "#E80E0E"; 
	private static final String MEDIUM = "#E8B80E"; 
	private static final String LOW = "#12E80E"; 
	
	private static final String BACKGROUNDCOLOR = "background-color"; 

    @Id("title")
	private Button title;
	@Id("assignedUser")
	private Button assignedUser;
	@Id("priority")
	private Button priority;
	private String status; 
	private int ticketNum; 

	/**
     * Creates a new TicketComponent.
     */
    public TicketComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between TicketComponent and ticket-component
     */
    public interface TicketComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setColor(String priorityLevel) {
    	if (priorityLevel.equals("high")) {
    		priority.getStyle().set(BACKGROUNDCOLOR, HIGH); 
    		priority.setText("HIGH");
    	}
    	else if (priorityLevel.equals("medium")) {
    		priority.getStyle().set(BACKGROUNDCOLOR, MEDIUM); 
    		priority.setText("MEDIUM");
    	}
    	else if (priorityLevel.equals("low")) {
    		priority.getStyle().set(BACKGROUNDCOLOR, LOW); 
    		priority.setText("LOW");
    	}
    }
    
    public void setAssignedUser(String user) {
    	assignedUser.setText(user);
    }
    
    public void setTitle(String name) {
    	title.setText(name);
    }
    
    public void setStatus(String status) {
    	this.status = status;
    }
    
    public String getStatus() {
    	return status; 
    }
    
    public int getTicketNum() {
    	return ticketNum; 
    }
    
    public void setTicketNum(int index) {
    	ticketNum = index; 
    }
    
    public void setPriority(ComponentEventListener<ClickEvent<Button>> listener) {
    	priority.addClickListener(listener); 
    }
}
