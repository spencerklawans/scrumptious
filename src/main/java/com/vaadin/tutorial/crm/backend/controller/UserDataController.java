package com.vaadin.tutorial.crm.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.entity.UserData;
import com.vaadin.tutorial.crm.backend.repository.UserDataRepository;

@Service
public class UserDataController {
		
	@Autowired
	UserDataRepository userDataRepository;   
    
    public void saveUser(UserData ud) {
    	userDataRepository.save(ud);
    }
    
    public void addUser(String email) {
    	UserData user = new UserData(email);
    	saveUser(user);
    	
    }
    
    public UserData getFromEmail(String email)
    {
    	return userDataRepository.findByEmail(email);
    }
    
    public void addProject(String email, Long projectId)
    {
    	UserData user = getFromEmail(email);
    	if (!(user.getProjects().contains(projectId)))
    			user.addProjectId(projectId);
    }
    
    public void removeProject(String email, Long projectId)
    {
    	UserData user = getFromEmail(email);
    	if (user.getProjects().contains(projectId))
    		user.removeProjectId(projectId);
    }
}
