package com.scrumptious.logic.ui;

import com.scrumptious.logic.backend.controller.UserSessionController;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.scrumptious.logic.backend.controller.ProjectController;
import com.scrumptious.logic.backend.controller.UserDataController;

import java.time.LocalDate;
import java.util.*;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.button.Button;
import org.vaadin.gatanaso.MultiselectComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

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
	@Id("cancelButton")
	private Button cancelButton;
	@Id("updateButton")
	private Button updateButton;
	
	private int ticketNum;
	
	private MultiselectComboBox<String> addAssignees; 
	
	ProjectController pc;
	UserSessionController usc;
	UserDataController udc; 
	
	@Id("assigneeWrapper")
	private HorizontalLayout assigneeWrapper;
	/**
     * Creates a new EditTicket.
     */
    public EditTicket(ProjectController pc, UserSessionController usc, UserDataController udc) {
        // You can initialise any data required for the connected UI components here.
    	this.pc = pc;
    	this.usc = usc;
    	this.udc = udc;
   
    	addAssignees = new MultiselectComboBox<>(); 
    	addAssignees.setLabel("Add Assignees");
    	addAssignees.setItems(pc.getUsers(usc.getPid()));
    	addAssignees.getStyle().set("margin-top", "S"); 
    	assigneeWrapper.add(addAssignees);
    	status.setItems("To Do", "In Progress", "Completed");
    	priority.setItems("Low", "Medium", "High");
    }

    /**
     * This model binds properties between EditTicket and edit-ticket
     */
    public interface EditTicketModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setTextDetails(String title, String description) {
    	this.title.setValue(title);
    	this.description.setValue(description);
    }
    
    public void setDates(LocalDate dateAssigned, LocalDate dateDue) {
    	this.dateAssigned.setValue(dateAssigned);
    	this.dateDue.setValue(dateDue);
    }
    
    public void setPriority(String priority) {
    	this.priority.setValue(priority);
    }
    
    public void setStatus(String status) {
    	this.status.setValue(status);
    }
    
    public int getTicketNum() {
    	return ticketNum; 
    }
    
    public void setTicketNum(int num) {
    	ticketNum = num; 
    }
    
    public Button getUpdateButton() {
    	return updateButton; 
    }
    
    public Button getCancelButton() {
    	return cancelButton; 
    }
    
    public String getTitle() {
    	return title.getValue(); 
    }
    
    public String getDescription() {
    	return description.getValue(); 
    }
    
    public LocalDate getDateDue() {
    	return dateDue.getValue(); 
    }
    
    public String getPriority() {
    	return priority.getValue(); 
    }
    
    public String getStatus() {
    	return status.getValue(); 
    }
    
    public void setAssignees(List<String> assignees) {
    	Set<String> assigneeSet = new HashSet<>(); 
    	for (String assignee : assignees) 
    		assigneeSet.add(assignee);
    	addAssignees.setValue(assigneeSet);
    }
    
    public List<String> getAssignees() {
    	ArrayList<String> emails = new ArrayList<>();
		for (String name : addAssignees.getValue())
		{
			if (name.contains("@"))	
				emails.add(udc.getFromEmail(name).getEmail()); 
			else
				emails.add(udc.getFromDisplay(name).getEmail());
		}
		return emails; 
    }
    
    public LocalDate getAssignedDate() {
    	return dateAssigned.getValue(); 
    }
}
