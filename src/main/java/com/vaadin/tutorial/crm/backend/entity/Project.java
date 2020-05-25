package com.vaadin.tutorial.crm.backend.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Project {
	
	final private int id;
	private String name;
	//private ArrayList<User> users; is needed??
	private String description;
	final private LocalDateTime dateCreated;
	private ArrayList<User> admins;
	private ArrayList<User> team;

	public Project() {
		this.id = 0;
		this.dateCreated = LocalDateTime.now();
		// TODO: new project constructor
	}
	
	public Project(String placeholder) {
		this.id = 0;
		this.dateCreated = LocalDateTime.now();//This should be replaced with paramter and database data
		//TODO: project from database call constructor
	}
	
	public String getName() {return this.name;}
	
	public void setName(String name) {this.name = name;}
	
	public String getDescription() {return this.description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public LocalDateTime getDateCreated() {return this.dateCreated;}
	
	
	public ArrayList<User> getAdmins(){return this.admins;}
	
	public int promoteUser(User user) {
		// returns current number of admins
		this.admins.add(user);
		return this.admins.size();
	}
	
	public boolean demoteUser(User user) {
		// returns true if user was revoked of admin status
		for (int i = 0; i < this.admins.size(); i++) {
			if (this.admins.get(i).equals(user)){
				this.admins.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<User> getTeam(){return this.team;}
	
	public int addMember(User user) {
		// returns updated count of team members on project
		this.team.add(user);
		return this.team.size();
	}
	
	public boolean removeMember(User user) {
		// returns true if user was removed from team member list
		for (int i = 0; i < this.team.size(); i++) {
			if (this.team.get(i).equals(user)){
				this.team.remove(i);
				return true;
			}
		}
		return false;
	}
}
