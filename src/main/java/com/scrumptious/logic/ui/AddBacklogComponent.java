package com.scrumptious.logic.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the add-backlog-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-backlog-component")
@JsModule("./src/views/add-backlog-component.js")
public class AddBacklogComponent extends PolymerTemplate<AddBacklogComponent.AddBacklogComponentModel> {

    @Id("addButton")
	private Button addButton;

	/**
     * Creates a new AddBacklogComponent.
     */
    public AddBacklogComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between AddBacklogComponent and add-backlog-component
     */
    public interface AddBacklogComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	addButton.addClickListener(e ->
    		addButton.getUI().ifPresent(ui -> ui.navigate("add-backlog")));
    }
}
