package com.scrumptious.logic.ui;

import com.scrumptious.logic.backend.controller.TicketController;
import com.scrumptious.logic.backend.controller.UserSessionController;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.combobox.ComboBox;

/**
 * A Designer generated component for the add-to-backlog template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-to-backlog")
@JsModule("./src/views/add-to-backlog.js")
public class AddToBacklog extends PolymerTemplate<AddToBacklog.AddToBacklogModel> {

    @Id("cancelButton")
	private Button cancelButton;
	@Id("addButton")
	private Button addButton;
	@Id("title")
	private TextField title;
	@Id("description")
	private TextField description;
	@Id("priority")
	private ComboBox<String> priority;
	
	TicketController tc;
	UserSessionController usc;

	/**
     * Creates a new AddToBacklog.
     */
    public AddToBacklog(TicketController tc, UserSessionController usc) {
        // You can initialise any data required for the connected UI components here.
    	this.tc = tc; 
    	this.usc = usc; 
    	priority.setItems("Low", "Medium", "High");
    }

    /**
     * This model binds properties between AddToBacklog and add-to-backlog
     */
    public interface AddToBacklogModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	cancelButton.addClickListener(e ->
    		cancelButton.getUI().ifPresent(ui -> ui.navigate("backlog"))
    	);
    	
    	addButton.addClickListener(e -> {
    		tc.addBacklog(title.getValue(), description.getValue(), priority.getValue(), usc.getPid());
    		addButton.getUI().ifPresent(ui -> ui.navigate("backlog"));
    	});
    }
}
