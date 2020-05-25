package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the add-project-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-project-component")
@JsModule("./src/views/add-project-component.js")
public class AddProjectComponent extends PolymerTemplate<AddProjectComponent.AddProjectComponentModel> {

    @Id("addButton")
	private Button addButton;

	/**
     * Creates a new AddProjectComponent.
     */
    public AddProjectComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between AddProjectComponent and add-project-component
     */
    public interface AddProjectComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButton() {
    	addButton.addClickListener(e -> {
    		addButton.getUI().ifPresent(ui -> ui.navigate("add-project")); 
    	});
    }
}
