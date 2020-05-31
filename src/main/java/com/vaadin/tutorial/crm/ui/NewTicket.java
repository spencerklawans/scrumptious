package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.PriorityEnum;
import com.vaadin.tutorial.crm.backend.entity.StatusEnum;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import org.vaadin.gatanaso.MultiselectComboBox;

import java.util.ArrayList;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

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
	
	private MultiselectComboBox<String> possibleMembers;
	
	/**
     * Creates a new NewTicket.
     */

	TicketController tc;
	UserSessionController usc;
	ProjectController pc;
	UserDataController udc;
	@Id("comboWrapper")
	private HorizontalLayout comboWrapper;
	@Id("status")
	private ComboBox<String> status;
	@Id("priority")
	private ComboBox<String> priority;


	public NewTicket(TicketController tc, UserSessionController usc, ProjectController pc,
					 UserDataController udc) {
        // You can initialise any data required for the connected UI components here.
    	this.tc = tc;
    	this.usc = usc;
    	this.pc = pc;
    	this.udc = udc;

    	priority.setLabel("Priority");
    	priority.setItems("Low", "Medium", "High");
    	status.setLabel("Status");
    	status.setItems("To Do", "In Progress", "Completed");
    	
    	possibleMembers = new MultiselectComboBox<>(); 
    	possibleMembers.setLabel("Add Assignees");
    	possibleMembers.setItems(pc.getUsers(usc.getPid()));
    	comboWrapper.add(possibleMembers);
    	
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

		createButton.addClickListener(e -> {
			parseTicket();
			createButton.getUI().ifPresent(ui -> ui.navigate("tickets"));
		});
    }

    public void parseTicket()
	{
		StatusEnum se;
		PriorityEnum pe;

		switch (status.getValue())
		{
			case "To Do":
				se = StatusEnum.TODO;
				break;
				
			case "In Progress":
				se = StatusEnum.INPROGRESS;
				break;
				
			case "Completed":
				se = StatusEnum.DONE;
				break;
				
			default:
				se = StatusEnum.TODO; 
				
		}
		switch (priority.getValue())
		{
			case "Low":
				pe = PriorityEnum.LOW;
				break;
				
			case "Medium":
				pe = PriorityEnum.MEDIUM;
				break;
				
			case "High":
				pe = PriorityEnum.HIGH;
				break;
				
			default: 
				pe = PriorityEnum.LOW; 
		}

		ArrayList<String> emails = new ArrayList<>();
		for (String name : possibleMembers.getValue())
		{
			emails.add(udc.getFromDisplay(name).getEmail());
		}
		Ticket t = new Ticket(title.getValue(), pe, se, emails, description.getValue(),
				dateAssigned.getValue(), dateDue.getValue());
		pc.addTicket(usc.getPid(), t);
	}
}
