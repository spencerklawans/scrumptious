package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.time.LocalDate;
import java.util.Date;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the project-mini-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("project-mini-component")
@JsModule("./src/views/project-mini-component.js")
public class ProjectMiniComponent extends PolymerTemplate<ProjectMiniComponent.ProjectMiniComponentModel> {

    @Id("title")
	private Button title;
	@Id("dateCreated")
	private Button dateCreated;
	@Id("owner")
	private Button owner;

	/**
     * Creates a new ProjectMiniComponent.
     */
    public ProjectMiniComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between ProjectMiniComponent and project-mini-component
     */
    public interface ProjectMiniComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setName(String name) {
    	title.setText(name);
    }
    
    public void setDate(LocalDate date) {
    	dateCreated.setText(date.toString());
    }
    
    public void setOwner(String team) {
    	owner.setText(team);
    }
}
