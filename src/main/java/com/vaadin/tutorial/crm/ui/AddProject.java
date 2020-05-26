package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.ArrayList;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.User;
import com.vaadin.tutorial.crm.ui.HeaderComponent;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout.FormItem;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.TextField;

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
    		getFormData(); 
    		createButton.getUI().ifPresent(ui -> ui.navigate("projects")); 
    	});
    }
    
    public void getFormData() {
    	Project p = new Project(); 
    	p.setName(nameField.getValue());
    	p.setDescription(descriptionField.getValue());
//    	METHOD NOT DEFINED IN GALEN's WORKING COPY
//    	p.setTeam(buildTeam());
    }
    
    public ArrayList<User> buildTeam() {
    	String[] names = teamField.getValue().split(","); 
    	ArrayList<User> team = new ArrayList<>(); 
    	for (String name : names) {
    		//User user = new User(name); 
    		//team.add(user); 
    	}
    	return team; 		
    }
}