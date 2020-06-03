package com.scrumptious.logic.backend.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.scrumptious.logic.backend.entity.PriorityEnum;
import com.scrumptious.logic.backend.entity.StatusEnum;
import com.scrumptious.logic.backend.entity.Ticket;
import com.scrumptious.logic.backend.entity.UserData;
import com.scrumptious.logic.backend.repository.ProjectRepository;
import com.scrumptious.logic.ui.BacklogMiniComponent;
import com.scrumptious.logic.ui.ProjectMiniComponent;
import com.scrumptious.logic.ui.TicketComponent;
import com.scrumptious.logic.ui.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrumptious.logic.backend.entity.Project;

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
           
    public Project addProject(String name, String description, LocalDate date, String team) {
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
				return null;
    	}
    	p.setUserEmails(userEmailList);
		if (projectRepository == null)
			return p;
    	if (projectRepository.findByNameAndDescription(p.getName(), p.getDescription()) != null)
			return null;
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
    	return p;
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
    		if (name != "")
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
			if (udc.getFromEmail(username).getFullName() == null)
				userComponent.setName("");
			else
				userComponent.setName(udc.getFromEmail(username).getFullName()); 
			userComponent.setEmail(username);
			miniComponents.add(userComponent);
		}
		return miniComponents;
	}

	public List<BacklogMiniComponent> buildBacklogComponents(Long pid) {
		ArrayList<BacklogMiniComponent> miniComponents = new ArrayList<>();
		int index = 0; 
		for (Ticket t : tc.findTicketsByPid(pid)) {
			if (t.getStatus().equals(StatusEnum.BACKLOG)) {
				BacklogMiniComponent bmc = new BacklogMiniComponent(); 
				bmc.setTitle(t.getTitle());
				bmc.setPriority(getPriorityLevel(t));
				bmc.setIndex(index);
				miniComponents.add(bmc); 
			}
			index++; 
		}
		return miniComponents;
	}

    public void pushProject(Project p) {
    	projectRepository.save(p);
    }

    public List<TicketComponent> buildTicketComponents(Long pid) {
    	ArrayList<TicketComponent> ticketComponents = new ArrayList<>(); 
    	int index = 0; 
    	for (Ticket t : tc.findTicketsByPid(pid)) {
    		if (!(t.getStatus().equals(StatusEnum.BACKLOG))) {
    			TicketComponent ticket = new TicketComponent();
    			ticket.setAssignedUser(getAssigneeNames(t.getAssignees()));
    			ticket.setTitle(t.getTitle());
    			ticket.setColor(getPriorityLevel(t));
    			ticket.setStatus(getStatus(t));
    			ticket.setTicketNum(index);
    			ticket.setDate(t.getDueDate().toString());
    			ticketComponents.add(ticket);
    		}
    		index++; 
    	}
    	return ticketComponents; 
    }

	public List<String> getUsers(Long pid)
	{
		ArrayList<String> returnList = new ArrayList<>();
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
