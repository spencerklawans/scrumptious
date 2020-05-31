package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.templatemodel.TemplateModel;


import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A Designer generated component for the add-project template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-project")
@JsModule("./src/views/add-project.js")
@Route(value = "add-project")
public class AddProject extends PolymerTemplate<AddProject.AddProjectModel> {

    @Id("header")
	private HeaderComponent header;
	@Id("cancelButton")
	private Button cancelButton;
	@Id("createButton")
	private Button createButton;
	@Id("datePicked")
	private DatePicker datePicked;
	@Id("nameField")
	private TextField nameField;
	@Id("descriptionField")
	private TextField descriptionField;
	@Id("teamField")
	private TextField teamField;
	
	@Autowired
	private ProjectController projectController; 

	/**
     * Creates a new AddProject.
     */
    public AddProject() {
        // You can initialise any data required for the connected UI components here.
    	header.setLogo();
    	header.setUserButton();
    	setNavButtons(); 
    }

    /**
     * This model binds properties between AddProject and add-project
     */
    public interface AddProjectModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	cancelButton.addClickListener(e -> {
    		cancelButton.getUI().ifPresent(ui -> ui.navigate("projects")); 
    	});
    	
    	createButton.addClickListener(e -> {
    		if (nameField.isEmpty())
    			Notification.show("Name field cannot be empty");
    		else {
				projectController.addProject(nameField.getValue(), descriptionField.getValue(), datePicked.getValue(), teamField.getValue());
				createButton.getUI().ifPresent(ui -> ui.navigate("projects"));
			}
    	});
    }
}
