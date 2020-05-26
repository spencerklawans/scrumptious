package com.vaadin.tutorial.crm.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.tutorial.crm.UserLoginEvent;
import com.vaadin.tutorial.crm.backend.entity.User;
import com.vaadin.tutorial.crm.backend.repository.UserRepository;
import java.util.List;

@RestController
public class DatabaseController {
	
	private static DatabaseController dbc;
    private static User currUser;
	
	public static synchronized DatabaseController getInstance()
	{
		if (dbc == null)
			dbc = new DatabaseController();
		return dbc;
	}
	
    @Autowired
    private UserRepository userRepository;
    
    public void updateUser(UserLoginEvent login) {
    	if (login == null)
    		return;
    	login.getUserId();
    	currUser = (User) userRepository.findByUid(login.getUserId());
    	if (currUser == null)
    		currUser = createFromLogin(login);
    }
    
    public User getCurrUser() {
    	return currUser;
    }
    
    public void saveUser() {
    	userRepository.save(currUser);
    }
    
    public User createFromLogin(UserLoginEvent login)
    {
    	User newUser = new User(login.getFirstName() , login.getLastName(), login.getEmail(), login.getUserId(), login.getPictureUrl());
    	userRepository.save(newUser);
    	return newUser;
    }
    
    
}
