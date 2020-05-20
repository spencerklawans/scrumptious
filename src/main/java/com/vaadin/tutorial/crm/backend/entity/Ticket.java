package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class Ticket {
	
	final private int id = 0; // placeholder int
	private String title;
	private PriorityEnum priority;
	private StatusEnum status;
	private ArrayList<User> assignees;
	private String description;
	private LocalDateTime assigned;
	private LocalDateTime dueDate;
	

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
	
	public ArrayList<User> getAssignees() {return this.assignees;}
	
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
	
	public LocalDateTime getAssigned() {return this.assigned;}
	
	public void setAssigned(LocalDateTime dt) {
		// likely will be replaced with string parameter (or what comes 
		// out of Vaadin component input processing
		this.assigned = dt;
	}
	
	public LocalDateTime getDueDate() {return this.dueDate;}
	
	public void setDueDate(LocalDateTime dt) {
		// see setAssigned
		this.dueDate = dt;
	}
	
	public String jsonify(){
        // TODO: update to return json to be pushed to database
		// TODO: Deprecated?? using raw ticket data in db push?
        return "Pushed to database";
    }
	
}
