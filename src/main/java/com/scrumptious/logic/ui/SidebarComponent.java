package com.scrumptious.logic.ui;

import com.scrumptious.logic.backend.controller.UserSessionController;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.scrumptious.logic.backend.controller.ProjectController;

/**
 * A Designer generated component for the sidebar-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("sidebar-component")
@JsModule("./src/views/sidebar-component.js")
public class SidebarComponent extends PolymerTemplate<SidebarComponent.SidebarComponentModel> {

	@Id("toCalendar")
	private Button toCalendar;
	@Id("toTickets")
	private Button toTickets;
	@Id("toTeam")
	private Button toTeam;
	@Id("toProjectPage")
	private Button toProjectPage;
	@Id("toBacklog")
	private Button toBacklog;

	/**
     * Creates a new SidebarComponent.
     */

	UserSessionController usc;

	private ProjectController projectController;

	@Id("projectName")
	private Button projectName;

	private static final String RGB = "rgba(49, 188, 205, 0.8)";
	private static final String BG = "background-color";

    public SidebarComponent(UserSessionController usc, ProjectController projectController){
        // You can initialise any data required for the connected UI components here.
		this.usc = usc;
		this.projectController = projectController;

		projectName.setText(projectController.findPid(usc.getPid()).getName());
    }

    public ProjectController getProjectController(){return projectController;}

    public interface SidebarComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	toBacklog.addClickListener(e ->
    		toBacklog.getUI().ifPresent(ui -> ui.navigate("backlog")));
    	
    	toProjectPage.addClickListener(e ->
    		toProjectPage.getUI().ifPresent(ui -> ui.navigate("projects")));

    	
    	toTickets.addClickListener(e ->
			toTickets.getUI().ifPresent(ui -> ui.navigate("tickets")));
    	
		toTeam.addClickListener(e ->
			toTeam.getUI().ifPresent(ui -> ui.navigate("team")));

    	toCalendar.addClickListener(e ->
    		toCalendar.getUI().ifPresent(ui -> ui.navigate("calendar")));
    }
    
    public void setBacklogColor() {
    	toBacklog.getStyle().set(BG, RGB);
    }
    
    public void setCalendarColor() {
    	toCalendar.getStyle().set(BG, RGB);
    }
    	
    public void setTicketsColor() {
    	toTickets.getStyle().set(BG, RGB);
    }
    
    public void setTeamColor() {
    	toTeam.getStyle().set(BG,RGB);
    }
    
}
