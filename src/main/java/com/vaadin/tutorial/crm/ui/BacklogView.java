package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.templatemodel.TemplateModel;

//import java.util.Optional;

//import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
//import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
//import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
//import com.vaadin.flow.component.button.Button;
//import com.vaadin.tutorial.crm.ui.SidebarComponent;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.ui.AddBacklogComponent;

/**
 * A Designer generated component for the backlog-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-view")
@JsModule("./src/views/backlog-view.js")
@Route(value = "backlog")
public class BacklogView extends PolymerTemplate<BacklogView.BacklogViewModel> {

	@Id("sidebar")
	private SidebarComponent sidebar;
	@Id("header")
	private HeaderComponent header;
	@Id("addComponent")
	private AddBacklogComponent addComponent;
	@Id("columnThree")
	private VerticalLayout columnThree;
	@Id("columnTwo")
	private VerticalLayout columnTwo;
	@Id("columnOne")
	private VerticalLayout columnOne;

	private ProjectController projectController;

	/**
     * Creates a new BacklogView.
     */

    public BacklogView(ProjectController projectController) {
        // You can initialise any data required for the connected UI components here.
		this.projectController = projectController;
    	sidebar.setNavButtons();
    	header.setLogo();
    	header.setUserButton();
    	addComponent.setNavButtons();
//    	add null check if there is no project associated w the session.
    	this.populateBacklog();

    }
    public int populateBacklog() {
		int i = 0;
		for (BacklogMiniComponent backlogMiniComponent:
				projectController.buildBacklogComponents()) {
			switch (i % 3){
				case 0:
					columnOne.add(backlogMiniComponent);
					break;
				case 1:
					columnTwo.add(backlogMiniComponent);
					break;
				case 2:
					columnThree.add(backlogMiniComponent);
					break;
				default:
					return 1;
			}
			i += 1;
		}
    	return 0;
	}

    /**
     * This model binds properties between BacklogView and backlog-view
     */
    public interface BacklogViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
