package com.vaadin.tutorial.crm.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.tutorial.crm.ui.BacklogMiniComponent;
import com.vaadin.tutorial.crm.ui.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.UserData;
import com.vaadin.tutorial.crm.backend.repository.ProjectRepository;
import com.vaadin.tutorial.crm.ui.ProjectMiniComponent;

@Service
public class ProjectController {
	    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserDataController udc = new UserDataController();
    
    @Autowired
    UserSessionController usc = new UserSessionController();
           
    public boolean addProject(String name, String description, LocalDate date, String team) {
    	Project p; 
    	if (date == null) {
    		p = new Project(); 
    	}
    	else {
    		p = new Project(date); 
    	}
    	p.setName(name);
    	p.setDescription(description);
    	p.setCreator(usc.getFullName());
    	ArrayList<String> userEmailList = (ArrayList<String>) buildTeam(team);
    	userEmailList.add(usc.getEmail());
    	for (int i = 0; i < userEmailList.size(); i++)
    	{
    		System.out.println(userEmailList.get(i));
    	}
    	p.setUserEmails(userEmailList);
    	if (projectRepository.findByNameAndDescription(p.getName(), p.getDescription()) != null)
    		return false;
    	pushProject(p);
    	for (String email : userEmailList)
    	{
    		UserData currUser = udc.getFromEmail(email);
    		if (currUser == null)
    		{
    			udc.addUser(email);
    			currUser = udc.getFromEmail(email);
    		}
    		p = projectRepository.findByNameAndDescription(p.getName(), p.getDescription());
    		currUser.addProjectId(p.getId());
    		udc.saveUser(currUser);
    	}
    	return true;
    }
    
    //replace with call to db that finds user associated with email
    public List<String> buildTeam(String team) {
    	String[] names = team.split(","); 
    	ArrayList<String> teamList = new ArrayList<>(); 
    	for (String name : names) {
    		name = name.trim();
    		teamList.add(name); 
    	}
    	return teamList; 		
    }

    public Project findPid(Long pid)
	{
		return projectRepository.findById(pid).get();
	}

    public List<ProjectMiniComponent> buildProjComponents() {
    	ArrayList<ProjectMiniComponent> miniComponents = new ArrayList<>(); 
    	for (Long projectId : udc.getFromEmail(usc.getEmail()).getProjects()) {
   		ProjectMiniComponent projComponent = new ProjectMiniComponent();
   			Project project = projectRepository.findById(projectId).get();
    		projComponent.setName(project.getName());
    		projComponent.setDate(project.getDateCreated());
    		projComponent.setOwner(project.getCreator());
    		projComponent.getElement().addEventListener("click", e -> {
    			usc.setPid(project.getId());
    			projComponent.getUI().ifPresent(ui -> ui.navigate("tickets"));
    			});
    		miniComponents.add(projComponent); 
    	}


    	return miniComponents;
    }
	public List<UserComponent> buildUserComponents() {
		ArrayList<UserComponent> miniComponents = new ArrayList<>();
		Project project = projectRepository.findById(usc.getPid()).get();
		for (String username : project.getUsers()) {
			UserComponent userComponent = new UserComponent();

			userComponent.setDetails(username);
			miniComponents.add(userComponent);
		}
		return miniComponents;
	}
//	TODO: cannot be done yet because no access to
	public List<BacklogMiniComponent> buildBacklogComponents() {
		ArrayList<BacklogMiniComponent> miniComponents = new ArrayList<>();
		Project project = projectRepository.findById(usc.getPid()).get();

		return miniComponents;
	}

    public void createNewTicket(){
        //Calls on TicketController to create a ticket and update the database with the info.
        // adds ticket to currentProject.tickets
    }
   	
	
    public void pushProject(Project p) {
    	projectRepository.save(p);
    }

}
