package com.vaadin.tutorial.crm.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.ui.BacklogMiniComponent;
import com.vaadin.tutorial.crm.ui.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.PriorityEnum;
import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.StatusEnum;
import com.vaadin.tutorial.crm.backend.entity.UserData;
import com.vaadin.tutorial.crm.backend.repository.ProjectRepository;
import com.vaadin.tutorial.crm.ui.ProjectMiniComponent;
import com.vaadin.tutorial.crm.ui.TicketComponent;

@Service
public class ProjectController {
	    
    @Autowired
    ProjectRepository projectRepository;
    
    @Autowired
    UserDataController udc = new UserDataController();
    
    @Autowired
    UserSessionController usc = new UserSessionController();

    @Autowired
	TicketController tc = new TicketController();
           
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
    		if(!checkEmailStyle(userEmailList.get(i)))
    			return false;
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

    public void addMember(String email, long pid)
	{
		Project p = findPid(pid);
		UserData newMember = udc.getFromEmail(email);
		if(newMember == null)
		{
			udc.addUser(email);
			newMember = udc.getFromEmail(email);
		}
		newMember.addProjectId(pid);
		udc.saveUser(newMember);
		p.addMember(email);
		pushProject(p);
	}

    public boolean checkEmailStyle(String s)
	{
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
				"[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
				"A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (s == null)
			return false;
		return pat.matcher(s).matches();
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
   			Project project = findPid(projectId);
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
		Project project = findPid(usc.getPid());
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
		Project project = findPid(usc.getPid());

		return miniComponents;
	}

    public void createNewTicket(){
        //Calls on TicketController to create a ticket and update the database with the info.
        // adds ticket to currentProject.tickets
    }
   	
	
    public void pushProject(Project p) {
    	projectRepository.save(p);
    }

//    public void addTicket(Long pid, Ticket t)
//	{
//
////		System.out.println(t.getTitle());
////		System.out.println(t.getDescription());
////		System.out.println(t.getDueDate());
//		Project p = findPid(pid);
//		p.addTicket(t);
//		pushProject(p);
//	}
    
    public List<TicketComponent> buildTicketComponents(Long pid) {
    	ArrayList<TicketComponent> ticketComponents = new ArrayList<>(); 
    	for (Ticket t : tc.findTicketsByPid(pid)) {
    		TicketComponent tc = new TicketComponent(); 
    		tc.setAssignedUser(getAssigneeNames(t.getAssignees()));
    		tc.setTitle(t.getTitle());
    		tc.setColor(getPriorityLevel(t));
    		tc.setStatus(getStatus(t));
    		ticketComponents.add(tc);
    	}
    	return ticketComponents; 
    }

	public ArrayList<String> getUsers(Long pid)
	{
		ArrayList<String> returnList = new ArrayList<String>();
		for (String email : findPid(pid).getUsers())
		{
			returnList.add(udc.getFromEmail(email).getDisplayName());
		}
		return returnList;
	}
	
	public String getAssigneeNames(List<String> emails) {
		String assignees = ""; 
		ArrayList<String> assigneeList = new ArrayList<>(); 
		for (String email : emails) {
			assigneeList.add(udc.getFromEmail(email).getDisplayName()); 
		}
		assignees = String.join(", ", assigneeList); 
		return assignees; 
	}
	
	public String getPriorityLevel(Ticket t) {
		if (t.getPriority() == PriorityEnum.HIGH) {
			return "high"; 
		}
		
		else if (t.getPriority() == PriorityEnum.MEDIUM) {
			return "medium"; 
		}
		else {
			return "low"; 
		}	
	}
	
	public String getStatus(Ticket t) {
		String s; 
		if (t.getStatus() == StatusEnum.TODO) {
			s = "to do"; 
		}
		else if (t.getStatus() == StatusEnum.INPROGRESS) {
			s = "in progress"; 
		}
		else if (t.getStatus() == StatusEnum.DONE) {
			s = "done"; 
		}
		else {
			s = ""; 
		}
		return s; 
	}

}
