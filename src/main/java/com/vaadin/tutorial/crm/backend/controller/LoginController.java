package com.vaadin.tutorial.crm.backend.controller;

import com.vaadin.tutorial.crm.backend.entity.User;

public class LoginController {
	
	private User user; //logged in user
	
	public void getUserFromDB(String email) {
		//TODO get the appropriate user data from the database
		//set this.user to DB entry
	}
	
	public void registerNewUser(String placeholderCredentials) {
		//Takes in google credentials and builds new user
		//User u = getNewUser(placeholderCredentials);
		//this.user = u; // Sets logged in user to new user
	}
	
	//public User getNewUser(String email) {
		//return new User(email);
	//}
	
	public boolean isInDatabase(String id) {
		//returns if the User with tag id is logged in the database
		return true;
	}
	
	

}
