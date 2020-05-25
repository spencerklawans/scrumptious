package com.vaadin.tutorial.crm.backend.entity;

public class ProjectController {
	
	//TODO Add LoginController interaction for constructor

    private Project currentProject;

    public Project buildProject(String name){
        return new Project(name);
    }

    public void createNewTicket(){
        //Calls on TicketController to create a ticket and update the database with the info.
        // adds ticket to currentProject.tickets
    }
    public void addCollaborator(User user){
        //should be more fleshed out -- Use return value (member count) for frontend rendering?
        this.currentProject.addMember(user);
    }

}
