package com.scrumptious.logic.backend.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class UserData extends AbstractEntity{
	
	private ArrayList<Long> projects;
	
    @NotNull
    @NotEmpty
	private String email;
	
	private String notes = "";

	private String fullName;

	private String displayName;

    public UserData(String email)
    {
    	this.email = email;
    	this.projects = new ArrayList<>();
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
		this.projects = new ArrayList<Long>();
    }

    public String getNotes(){return notes;}

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
    
    public List<Long> getProjects()
	{
		return this.projects;
	}
	
	public void addProjectId(Long projectId) {
		this.projects.add(projectId);
	}
	
	public void removeProjectId(Long projectId) {
		this.projects.remove(projectId);
	}

	public void setNotes(String notes){this.notes = notes;}
}
