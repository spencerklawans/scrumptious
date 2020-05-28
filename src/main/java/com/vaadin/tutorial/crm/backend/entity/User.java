package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity implements Cloneable {
	
	
	private ArrayList<Project> projects;
	private ArrayList<Ticket> tickets;
	private ArrayList<String> notes;
	private String bio;
	
    @NotNull
    @NotEmpty
    private String firstName = "";

    @NotNull
    @NotEmpty
    private String lastName = "";

    @NotNull
    @NotEmpty
    private String email = "";
    
    @NotNull
    @NotEmpty
    private String uid = "";
    
    @NotNull
    @NotEmpty
    private String picURL = "";
    
    public User(String firstName, String lastName, String email, String uid, String picURL)
    {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.email = email;
    	this.uid = uid;
    	this.picURL = picURL;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public String getPic() {
        return picURL;
    }

    public void setPic(String picURL) {
        this.picURL = picURL;
    }
    
    public String getFirstName() {
    	return firstName; 
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
	
	public void setBio(String bio) 
	{
		
		this.bio = bio;
		//userRepository.save(this);
	}
	
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

	@Override
	public Object clone() throws CloneNotSupportedException{
		User clone = (User)super.clone();
		return clone;
	}
}
