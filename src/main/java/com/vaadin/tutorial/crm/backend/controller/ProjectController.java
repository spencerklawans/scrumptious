package com.vaadin.tutorial.crm.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.UserData;
import com.vaadin.tutorial.crm.backend.repository.ProjectRepository;
import com.vaadin.tutorial.crm.backend.repository.UserDataRepository;
import com.vaadin.tutorial.crm.oauth.data.UserSession;
import com.vaadin.tutorial.crm.ui.ProjectMiniComponent;

@Service
public class ProjectController {
	
	//TODO Add LoginController interaction for constructor
//	private ArrayList<Project> projectList; 
	    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserDataController udc;
    
    @Autowired
    UserSessionController usc;
           
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
    	pushProject(p);
    	ArrayList<String> userEmailList = buildTeam(team);
    	userEmailList.add(usc.getEmail());
    	for (String email : userEmailList)
    	{
    		UserData currUser = udc.getFromEmail(email);
    		if (currUser == null)
    		{
    			udc.addUser(email);
    			currUser = udc.getFromEmail(email);
    		}
    		currUser.addProjectId(p.getId());
    		udc.saveUser(currUser);
    	}
    }
    
    //replace with call to db that finds user associated with email
    public ArrayList<String> buildTeam(String team) {
    	String[] names = team.split(","); 
    	ArrayList<String> teamList = new ArrayList<>(); 
    	for (String name : names) {
    		teamList.add(name); 
    	}
    	return teamList; 		
    }

    public List<ProjectMiniComponent> buildProjComponents() {
    	ArrayList<ProjectMiniComponent> miniComponents = new ArrayList<>(); 
    	for (Long projectId : udc.getFromEmail(usc.getEmail()).getProjects()) {
   		ProjectMiniComponent projComponent = new ProjectMiniComponent();
   			Project project = projectRepository.findById(projectId).get();
    		projComponent.setName(project.getName());
    		projComponent.setDate(project.getDateCreated());
//    		projComponent.setOwner(ownerList(project.getAdminList()));
    		projComponent.getElement().addEventListener("click", e -> { 
    			projComponent.getUI().ifPresent(ui -> ui.navigate("tickets"));
    			});
    		miniComponents.add(projComponent); 
    	}

    	return miniComponents;
    }
    

    public void createNewTicket(){
        //Calls on TicketController to create a ticket and update the database with the info.
        // adds ticket to currentProject.tickets
    }
   	
	
    public void pushProject(Project p) {
    	if (projectRepository == null)
    		System.out.println("projectRepository is null");
    	projectRepository.save(p);
    }

}
