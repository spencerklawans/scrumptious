package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;

/**
 * A Designer generated component for the new-ticket-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("new-ticket-main")
@JsModule("./src/views/new-ticket-main.js")
@Route(value = "create-ticket")
public class NewTicketMain extends PolymerTemplate<NewTicketMain.NewTicketMainModel> {

    @Id("newTicketForm")
	private NewTicket newTicketForm;
	@Id("header")
	private HeaderComponent header;
	@Id("sidebar")
	private SidebarComponent sidebar;

	/**
     * Creates a new NewTicketMain.
     */
	TicketController tc;
	UserSessionController usc;
	ProjectController pc;
	UserDataController udc;

	public NewTicketMain(TicketController tc, UserSessionController usc, ProjectController pc,
					 UserDataController udc) {
        // You can initialise any data required for the connected UI components here.
		this.tc = tc;
		this.usc = usc;
		this.pc = pc;
		this.udc = udc;
    	newTicketForm.setNavButtons();
    	header.setLogo();
    	header.setUserButton();
    	sidebar.setNavButtons();
    }

    /**
     * This model binds properties between NewTicketMain and new-ticket-main
     */
    public interface NewTicketMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
