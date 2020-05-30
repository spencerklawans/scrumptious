package com.vaadin.tutorial.crm.backend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vaadin.tutorial.crm.oauth.data.UserSession;

@Service
public class UserSessionController 
{
    @Autowired
    UserSession us = new UserSession();
    
    public String getEmail()
    {
    	return us.getUser().getEmail();
    }
}
