package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import org.vaadin.gatanaso.MultiselectComboBox;
import com.vaadin.flow.component.button.Button;

/**
 * A Designer generated component for the edit-ticket template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("edit-ticket")
@JsModule("./src/views/edit-ticket.js")
public class EditTicket extends PolymerTemplate<EditTicket.EditTicketModel> {

    @Id("title")
	private TextField title;
	@Id("description")
	private TextField description;
	@Id("dateAssigned")
	private DatePicker dateAssigned;
	@Id("dateDue")
	private DatePicker dateDue;
	@Id("status")
	private ComboBox<String> status;
	@Id("priority")
	private ComboBox<String> priority;
	@Id("addAssignees")
	private MultiselectComboBox addAssignees;
	@Id("cancelButton")
	private Button cancelButton;
	@Id("updateButton")
	private Button updateButton;

	/**
     * Creates a new EditTicket.
     */
    public EditTicket() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between EditTicket and edit-ticket
     */
    public interface EditTicketModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
