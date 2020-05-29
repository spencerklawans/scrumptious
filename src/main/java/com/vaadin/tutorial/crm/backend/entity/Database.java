package com.vaadin.tutorial.crm.backend.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaadin.tutorial.crm.backend.repository.UserRepository;

@Service
public class Database {
	
	private String uid;
	
	@Autowired
	UserRepository userRepository;
	
    private static User currUser;

    
    public User getCurrUser() {
    	return currUser;
    }
    
    public String getUid() {
    	return uid;
    }
    
    public void saveUser() {
    	userRepository.save(currUser);
    }
}
