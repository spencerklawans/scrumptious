package com.vaadin.tutorial.crm.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.UserLoginEvent;
import com.vaadin.tutorial.crm.backend.entity.User;
import com.vaadin.tutorial.crm.backend.repository.UserRepository;

@Service
public class DatabaseController {
	
	private String uid;
	
	@Autowired
	UserRepository userRepository;
	
    private static User currUser;
	
    public void updateUser(UserLoginEvent login) {
    	if (login == null)
    		return;
    	this.uid = login.getUserId();
    	login.getUserId();
    	currUser = (User) this.userRepository.findByUid(login.getUserId());
    	if (currUser == null)
    		currUser = createFromLogin(login);
    	
    }
    
    public User getCurrUser() {
    	return currUser;
    }
    
    public String getUid() {
    	return uid;
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
