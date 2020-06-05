package com.scrumptious.logic.backend.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Project extends AbstractEntity{
	
    private String name;
	private String description;
	private final LocalDate dateCreated;

	private ArrayList<String> userEmails;

	private String creator;

	public Project() {
		this.dateCreated = LocalDate.now();
		this.userEmails = new ArrayList<>();
	}
	
	public Project(LocalDate date) {
		this.dateCreated = date;//This should be replaced with paramter and database dat
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
		if (!(userEmails.contains(email))) {
			userEmails.add(email);
		}
	}
}