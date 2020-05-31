package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Ticket implements Serializable {
	
	private static final int ID = 0; // placeholder int
	private String title;
	private PriorityEnum priority;
	private StatusEnum status;
	private ArrayList<String> assigneeEmails;
	private String description;
	private LocalDate assigned;
	private LocalDate dueDate;
	

	public Ticket(String title, PriorityEnum pe, StatusEnum se, ArrayList<String> assigneeEmails,
	String description, LocalDate assigned, LocalDate dueDate) {
		this.title = title;
		this.priority = pe;
		this.status = se;
		this.assigneeEmails = assigneeEmails;
		this.description = description;
		this.assigned = assigned;
		this.dueDate = dueDate;
	}

	public String getTitle() {return this.title;}
	
	public void setTitle(String newTitle) {this.title = newTitle;}
	
	public PriorityEnum getPriority() {return this.priority;}
	
	public void setPriority(PriorityEnum newPriority) {this.priority = newPriority;}
	
	public StatusEnum getStatus() {return this.status;}
	
	public void setStatus(StatusEnum newStatus) {this.status = newStatus;}
	
	public List<String> getAssignees() {return this.assigneeEmails;}
	
	public void addAssignee(String user) {
		this.assigneeEmails.add(user);
	}
	
	public void removeAssignee(String user) {
		// Returns boolean whether user was removed from assignees
		assigneeEmails.remove(user);
	}
	
	public String getDescription() {return this.description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public LocalDate getAssigned() {return this.assigned;}
	
	public void setAssigned(LocalDate dt) {
		this.assigned = dt;
	}
	
	public LocalDate getDueDate() {return this.dueDate;}
	
	public void setDueDate(LocalDate dt) {
		// see setAssigned
		this.dueDate = dt;
	}
}
