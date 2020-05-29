package com.vaadin.tutorial.crm.backend.controller;

import java.time.LocalDate;

import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.User;
import com.vaadin.tutorial.crm.backend.entity.Database;

public class ProjectsController {
	
	User user;
	Database dbc;
	
	public ProjectsController(User user) {
		this.user = user;
	}
	
	public void addProject() {
		// add populated project to database and save to User ArrayList of Projects
		
	}
	
	public Project buildNewProject(LocalDate date) {
		//TODO adjust [this function/ addProject] parameters to use fields from form
		
		return new Project(date);
	}

}
