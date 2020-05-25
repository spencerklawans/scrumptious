package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;

public class User {
	
	private final String id; // temporarily an int
	//login info:
	private String name;
	private String email;
	private String pictureURL;
	private String locale;
	private String familyName;
	private String givenName;
	
	
	
	private ArrayList<Project> projects;
	//password hash??
	private ArrayList<Ticket> tickets;
	private String bio;
	private ArrayList<String> notes;
	
	public User(String id) {
		// new User constructor should at minimum require an email
		// TODO new user constructor
		this.id = id;
		
	}
	
	public User(String id, String placeholder) {
		// TODO user constructor from database call
		this.id = id;
		
	}
	
	public String getName() {return this.name;}
	
	public void setName(String newName) {this.name = newName;}
	
	public String getEmail() {return this.email;}
	
	public void setEmail(String email) throws IllegalArgumentException{
		// checks that parameter email is a valid email address before updating field
		String emailRegex = "^[\\w._%+-]+@[\\w.-]+\\.[A-Z]{2,}$";
		if (email.matches(emailRegex)) {
			this.email = email;
		}
		else {
			throw new IllegalArgumentException("Invalid email format.");
		}
	}
	
	public ArrayList<Project> getProjects(){return this.projects;}
	
	public void addProject(Project project, boolean override) throws DuplicateProjectException {
		// warns (via raising a custom exception) user project already exists in projects. 
		// Allows for override from caller
		if (override) {
			this.projects.add(project);
		}
		else {
			String name = project.getName();
			for (Project p: this.projects) {
				if (p.getName() == name) {
					throw new DuplicateProjectException(name);
				}
			}
			this.projects.add(project);
		}
	}
	
	public ArrayList<Ticket> getTickets(){return this.tickets;}
	
	public void addTicket(Ticket ticket, boolean override) throws DuplicateTicketException {
		// warns (via raising a custom exception) user ticket already exists in tickets. 
			// Allows for override from caller
		if (override) {
			this.tickets.add(ticket);
		}
		else {
			String name = ticket.getTitle();
			for (Ticket p: this.tickets) {
				if (p.getTitle() == name) {
					throw new DuplicateTicketException(name);
				}
			}
			this.tickets.add(ticket);
		}
	}
	
	public String getBio(){return this.bio;}
	
	public void setBio(String bio) {this.bio = bio;}
	
	public ArrayList<String> getNotes(){return this.notes;}
	
	public void addNote(String note) {
		this.notes.add(note);
	}
	
	public boolean removeNote(String note) {
		for (int i = 0; i < this.notes.size(); i++) {
			if (this.notes.get(i).equalsIgnoreCase(note)) {
				this.notes.remove(i);
				return true;
			}
		}
		return false;
	}

}
