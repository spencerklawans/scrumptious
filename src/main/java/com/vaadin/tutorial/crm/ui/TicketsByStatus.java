package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

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
    	createButton.addClickListener(e -> {
    		createButton.getUI().ifPresent(ui -> ui.navigate("create-ticket")); 
    	});
    }
}
