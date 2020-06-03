package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the add-to-backlog-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-to-backlog-main")
@JsModule("./src/views/add-to-backlog-main.js")
@Route(value = "add-backlog")
public class AddToBacklogMain extends PolymerTemplate<AddToBacklogMain.AddToBacklogMainModel> {

    @Id("header")
	private HeaderComponent header;
	@Id("sidebar")
	private SidebarComponent sidebar;
	@Id("addToBacklog")
	private AddToBacklog addToBacklog;
	
	TicketController tc; 
	UserSessionController usc; 

	/**
     * Creates a new AddToBacklogMain.
     */
    public AddToBacklogMain(TicketController tc, UserSessionController usc) {
        // You can initialise any data required for the connected UI components here.
    	this.tc = tc;
    	this.usc = usc;
    	header.setLogo();
    	sidebar.setNavButtons();
    	addToBacklog.setNavButtons();
    	header.setUserButton();
    }

    /**
     * This model binds properties between AddToBacklogMain and add-to-backlog-main
     */
    public interface AddToBacklogMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
