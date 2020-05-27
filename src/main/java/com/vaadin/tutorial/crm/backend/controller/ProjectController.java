package com.vaadin.tutorial.crm.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.User;
import com.vaadin.tutorial.crm.ui.ProjectMiniComponent;

public class ProjectController {
	
	//TODO Add LoginController interaction for constructor
	private ArrayList<Project> projectList; 
	
    private Project currentProject;

    public ProjectController() {
    	//replace this with a call to the db, i.e. get projects by user id
    	projectList = new ArrayList<>(); 
    	
    	//sample project to test display functionality
    	Project p = new Project(LocalDate.now()); 
    	p.setDescription("hi");
    	p.setName("project name");
    	p.setTeam(buildTeam(""));
    	p.setAdmins(buildTeam(""));
    	projectList.add(p);
    	
    }
    
    public void addProject(String name, String description, LocalDate date, String team) {
    	Project p; 
    	if (date == null) {
    		p = new Project(); 
    	}
    	else {
    		p = new Project(date); 
    	}
    	p.setName(name);
    	p.setDescription(description);
    	p.setTeam(buildTeam(team));
    	p.setAdmins(buildTeam(team));
    	
    	projectList.add(p); 
    }
    
    //replace with call to db that finds user associated with email
    public ArrayList<User> buildTeam(String team) {
    	String[] names = team.split(","); 
    	ArrayList<User> teamList = new ArrayList<>(); 
    	for (String name : names) {
    		User user = new User(name, null, null, null, null); 
    		teamList.add(user); 
    	}
    	return teamList; 		
    }
    
    public String ownerList(List<User> admins) {
    	String owners = ""; 
    	for (int i = 0; i < admins.size() - 1; i++) {
    		owners += admins.get(i).getFirstName() + ", ";
    	}
    	owners+= admins.get(admins.size() - 1).getFirstName(); 
    	return owners; 
    }


    public ArrayList<ProjectMiniComponent> buildProjComponents() {
    	ArrayList<ProjectMiniComponent> miniComponents = new ArrayList<>(); 
    	for (Project project : projectList) {
    		ProjectMiniComponent projComponent = new ProjectMiniComponent(); 
    		projComponent.setName(project.getName());
    		projComponent.setDate(project.getDateCreated());
    		projComponent.setOwner(ownerList(project.getAdmins()));
    		projComponent.getElement().addEventListener("click", e -> { 
    			projComponent.getUI().ifPresent(ui -> ui.navigate("tickets"));
    			this.currentProject = project;
    			});
    		miniComponents.add(projComponent); 
    	}

    	return miniComponents;
    }
    
    
//    public Project buildProject(String name){
//        return new Project(name);
//    }

    public void createNewTicket(){
        //Calls on TicketController to create a ticket and update the database with the info.
        // adds ticket to currentProject.tickets
    }
    public void addCollaborator(User user){
        //should be more fleshed out -- Use return value (member count) for frontend rendering?
        this.currentProject.addMember(user);
    }

}
