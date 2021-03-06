package com.scrumptious.logic.ui;

import com.scrumptious.logic.backend.controller.TicketController;
import com.scrumptious.logic.backend.controller.UserSessionController;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.scrumptious.logic.backend.controller.ProjectController;
import com.scrumptious.logic.backend.controller.UserDataController;

/**
 * A Designer generated component for the ticket-by-status-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("ticket-by-status-main")
@JsModule("./src/views/ticket-by-status-main.js")
@Route(value = "tickets")
public class TicketByStatusMain extends PolymerTemplate<TicketByStatusMain.TicketByStatusMainModel> {

    @Id("ticketStatusView")
	private TicketsByStatus ticketStatusView;
	@Id("header")
	private HeaderComponent header;
	@Id("sidebar")
	private SidebarComponent sidebar;

	TicketController tc;

	UserSessionController usc;
	ProjectController pc;
	UserDataController udc;

	/**
     * Creates a new TicketByStatusMain.
     */
    public TicketByStatusMain(UserSessionController usc, TicketController tc,
							  ProjectController pc, UserDataController udc) {
        // You can initialise any data required for the connected UI components here.
    	ticketStatusView.setNavButtons();
    	ticketStatusView.setWrapperStyle();
    	header.setLogo();
    	header.setUserButton();
    	sidebar.setNavButtons();
    	this.tc = tc;
    	this.usc = usc;
    	this.udc = udc;
    	this.pc = pc;
		ticketStatusView.populateTickets();
		sidebar.setTicketsColor();
    }

    /**
     * This model binds properties between TicketByStatusMain and ticket-by-status-main
     */
    public interface TicketByStatusMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
