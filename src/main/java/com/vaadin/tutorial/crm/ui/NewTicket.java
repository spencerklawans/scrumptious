package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the new-ticket template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("new-ticket")
@JsModule("./src/views/new-ticket.js")
public class NewTicket extends PolymerTemplate<NewTicket.NewTicketModel> {

    /**
     * Creates a new NewTicket.
     */
    public NewTicket() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between NewTicket and new-ticket
     */
    public interface NewTicketModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}