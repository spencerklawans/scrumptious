package com.scrumptious.logic.backend.entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket extends AbstractEntity{

	private String title;
	private PriorityEnum priority;
	private StatusEnum status;

	private ArrayList<String> assigneeEmails;
	private String description;
	private LocalDate assigned;
	private LocalDate dueDate;
	private Long pid;
	


	public Ticket(String title, PriorityEnum pe, StatusEnum se, ArrayList<String> assigneeEmails,
	String description, LocalDate assigned, LocalDate dueDate, Long pid) {
		this.title = title;
		this.priority = pe;
		this.status = se;
		this.assigneeEmails = assigneeEmails;
		this.description = description;
		this.assigned = assigned;
		this.dueDate = dueDate;
		this.pid = pid;

	}

	public Ticket()
	{

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

	public Long getPid(){ return this.pid;}
	
	public void setAssigneeEmails(ArrayList<String> emails) {
		assigneeEmails = emails;
	}
}
