package com.scrumptious.logic.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the backlog-mini-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-mini-component")
@JsModule("./src/views/backlog-mini-component.js")
public class BacklogMiniComponent extends PolymerTemplate<BacklogMiniComponent.BacklogMiniComponentModel> {
	private static final String HIGH = "#E80E0E"; 
	private static final String MEDIUM = "#E8B80E"; 
	private static final String LOW = "#12E80E"; 
	
	private static final String BACKGROUNDCOLOR = "background-color"; 
	
    @Id("title")
    private Button title;
    @Id("priority")
    private Button priority;
    private int ticketNum; 

    /**
     * Creates a new BacklogMiniComponent.
     */
    public BacklogMiniComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between BacklogMiniComponent and backlog-mini-component
     */
    public interface BacklogMiniComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setPriority(String priorityLevel) {
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
    
    public String getPriority() {
    	return priority.getText(); 
    }
    
    public int getTicketNum() {
    	return ticketNum; 
    }
    
    public void setIndex(int index) {
    	ticketNum = index; 
    }
    
    public void setPriorityListener(ComponentEventListener<ClickEvent<Button>> listener) {
    	priority.addClickListener(listener); 
    }
}
