package com.scrumptious.logic.backend.controller;

import com.scrumptious.logic.backend.entity.UserData;
import com.scrumptious.logic.backend.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public UserData getFromDisplay(String displayName)
    {
        return userDataRepository.findByDisplayName(displayName);
    }
}
