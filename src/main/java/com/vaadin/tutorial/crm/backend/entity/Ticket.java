package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Ticket {
	
	private static final int ID = 0; // placeholder int
	private String title;
	private PriorityEnum priority;
	private StatusEnum status;
	private ArrayList<User> assignees;
	private String description;
	private LocalDate assigned;
	private LocalDate dueDate;
	

	public Ticket() {
		//TODO: id generator function
		// id assignment should be replaced with a private (?static?) 
						// function call.
	}
	public Ticket(String placeholder) {
		//TODO: a constructor that is used by a controller function that 
		//populates a ticket from database info
		
	}
	
	// id getter function?? is there a need?
	
	public String getTitle() {return this.title;}
	
	public void setTitle(String newTitle) {this.title = newTitle;}
	
	public PriorityEnum getPriority() {return this.priority;}
	
	public void setPriority(PriorityEnum newPriority) {this.priority = newPriority;}
	
	public StatusEnum getStatus() {return this.status;}
	
	public void setStatus(StatusEnum newStatus) {this.status = newStatus;}
	
	public List<User> getAssignees() {return this.assignees;}
	
	public void addAssignee(User user) {
		this.assignees.add(user);
	}
	
	public Boolean removeAssignee(User user) {
		// Returns boolean whether user was removed from assignees
		for (int i = 0; i <= this.assignees.size(); i++) {
			if (this.assignees.get(i).equals(user)) {
				this.assignees.remove(i);
				return true;
				
			}
		}
		return false;
	}
	
	public String getDescription() {return this.description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public LocalDate getAssigned() {return this.assigned;}
	
	public void setAssigned(LocalDate dt) {
		// likely will be replaced with string parameter (or what comes 
		// out of Vaadin component input processing
		this.assigned = dt;
	}
	
	public LocalDate getDueDate() {return this.dueDate;}
	
	public void setDueDate(LocalDate dt) {
		// see setAssigned
		this.dueDate = dt;
	}
	
}
