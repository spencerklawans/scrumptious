package com.vaadin.tutorial.crm.backend.entity;

import java.util.ArrayList;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserData extends AbstractEntity implements Cloneable {
	
	private ArrayList<Long> projects;
	
    @NotNull
    @NotEmpty
	private String email;

	private String notes;

	private String fullName;

	private String displayName;
	    
    public UserData(String email)
    {
    	this.email = email;
    	this.projects = new ArrayList<Long>();
    	this.displayName = email;
    }

    public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

    public UserData()
    {
    	
    }

    public String getFullName()
	{
		return fullName;
	}

	public void setFullName(String fullName)
	{
		this.fullName = fullName;
	}

    public String getEmail() {
        return email;
    }
    
    public ArrayList<Long> getProjects()
	{
		return this.projects;
	}
	
	public void addProjectId(Long projectId) {
		this.projects.add(projectId);
	}
	
	public void removeProjectId(Long projectId) {
		this.projects.remove(projectId);
	}
	
	public String getNotes()
	{
		return notes;
	}
	
	public void setNotes(String n)
	{
		this.notes = n;
	}

	@Override
	public Object clone() throws CloneNotSupportedException{
		UserData clone = (UserData)super.clone();
		return clone;
	}
}
