package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
//import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.checkbox.CheckboxGroup;

/**
 * A Designer generated component for the new-ticket template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("new-ticket")
@JsModule("./src/views/new-ticket.js")
public class NewTicket extends PolymerTemplate<NewTicket.NewTicketModel> {

    @Id("cancelButton")
	private Button cancelButton;
	@Id("createButton")
	private Button createButton;
	@Id("title")
	private TextField title;
	@Id("description")
	private TextField description;
	@Id("dateAssigned")
	private DatePicker dateAssigned;
	@Id("dateDue")
	private DatePicker dateDue;
	@Id("possibleMembers")
	private ComboBox<String> possibleMembers;
	@Id("lowPriority")
	private Checkbox lowPriority;
	@Id("medPriority")
	private Checkbox medPriority;
	@Id("highPriority")
	private Checkbox highPriority;
	@Id("todoStatus")
	private Checkbox todoStatus;
	@Id("inProgressStatus")
	private Checkbox inProgressStatus;
	@Id("completedStatus")
	private Checkbox completedStatus;

	/**
     * Creates a new NewTicket.
     */
    public NewTicket() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between NewTicket and new-ticket
     */
    public interface NewTicketModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setNavButtons() {
    	cancelButton.addClickListener(e ->
    		cancelButton.getUI().ifPresent(ui -> ui.navigate("tickets"))
    	);
    	
    	createButton.addClickListener(e ->
    		createButton.getUI().ifPresent(ui -> ui.navigate("tickets"))
    	);
    }
}
