package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the sidebar-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("sidebar-component")
@JsModule("./src/views/sidebar-component.js")
public class SidebarComponent extends PolymerTemplate<SidebarComponent.SidebarComponentModel> {

    @Id("toBacklog")
	private Button toBacklog;
	@Id("toCalendar")
	private Button toCalendar;
	@Id("toTickets")
	private Button toTickets;
	@Id("toTeam")
	private Button toTeam;
	@Id("toProjectPage")
	private Button toProjectPage;

	/**
     * Creates a new SidebarComponent.
     */
    public SidebarComponent() {
        // You can initialise any data required for the connected UI components here.
    	
    }

    /**
     * This model binds properties between SidebarComponent and sidebar-component
     */
    public interface SidebarComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	toBacklog.addClickListener(e -> {
    		toBacklog.getUI().ifPresent(ui -> ui.navigate("backlog")); 
    	});
    	
    	toProjectPage.addClickListener(e -> {
    		toProjectPage.getUI().ifPresent(ui -> ui.navigate("projects")); 
    	});
    	
    	toTickets.addClickListener(e -> {
			toTickets.getUI().ifPresent(ui -> ui.navigate("tickets"));

		});
		toTickets.addClickListener(e -> {
			toTickets.getUI().ifPresent(ui -> ui.navigate("team"));

		});
    }
}
