package com.vaadin.tutorial.crm.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;


@Entity
public class Project extends AbstractEntity implements Cloneable {
	
    private String name;
	private String description;
	final private LocalDate dateCreated;
	
	private ArrayList<String> userEmails;
	
	private String creator;

	public Project() {
		this.dateCreated = LocalDate.now();
	}
	
	public Project(LocalDate date) {
		this.dateCreated = date;//This should be replaced with paramter and database data
	}
	
	public void setUserEmails(ArrayList<String> userEmails)
	{
		this.userEmails = userEmails;
	}
	
	public String getName() {return this.name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getCreator() {return this.creator;}
	
	public void setCreator(String creator) {this.creator = creator;}
	
	public String getDescription() {return this.description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public LocalDate getDateCreated() {return this.dateCreated;}
			
	public List<String> getUsers(){return this.userEmails;}
		
	public void addMember(String email) {
		// returns updated count of team members on project
		if (!(userEmails.contains(email)))
			userEmails.add(email);
	}
	
	public void removeMember(String email) {
		// returns true if user was removed from team member list
		if (userEmails.contains(email))
			userEmails.remove(email);
	}
}
