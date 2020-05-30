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
    
    public String getFullName()
    {
    	return (us.getUser().getFirstName() + " " + us.getUser().getLastName());
    }
    
    public Long getPid()
    {
    	return (us.pid);
    }
    
    public String getFirstName()
    {
    	return (us.getUser().getFirstName());
    }
    
    public void setPid(Long pid)
    {
    	us.pid = pid;
    }
    
    public String getPicUrl()
    {
    	return us.getUser().getPicture();
    }
}
