package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
//import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;
//import com.vaadin.tutorial.crm.ui.AddProjectComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.UserData;
import org.springframework.beans.factory.annotation.Autowired;

import javax.management.Notification;

/**
 * A Designer generated component for the main-project-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("project-view")
@JsModule("./src/views/project-view.js")
@Route(value = "projects")
public class ProjectView extends PolymerTemplate<ProjectView.ProjectViewModel> {

    @Id("header")
	private HeaderComponent header;
	@Id("addButton")
	private AddProjectComponent addButton;
	@Id("topLayout")
	private HorizontalLayout topLayout;
	
	private ProjectController projectController;

	UserSessionController usc;

	UserDataController udc;

	@Autowired
	TicketController tc;

	/**
     * Creates a new MainProjectView.
     */
    public ProjectView(ProjectController projectController, UserSessionController usc, UserDataController udc)
	{
        // You can initialise any data required for the connected UI components here.

    	this.projectController = projectController;
    	this.udc = udc;
    	this.usc = usc;
		if (udc.getFromEmail(usc.getEmail()) == null)
		{
			udc.addUser(usc.getEmail());
		}
		UserData curr = udc.getFromEmail(usc.getEmail());
		if (curr.getFullName() == null) {
			curr.setFullName(usc.getFullName());
			curr.setDisplayName(usc.getFullName());
		}
    	header.setLogo();
    	header.setUserButton();
    	addButton.setNavButton();
    	generateDisplay();
    }

    /**
     * This model binds properties between MainProjectView and main-project-view
     */
    public interface ProjectViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void generateDisplay() {
    	List<ProjectMiniComponent> compList = projectController.buildProjComponents();
    	for (ProjectMiniComponent pmc : compList) {
    		topLayout.add(pmc);
    	}
    }
}
