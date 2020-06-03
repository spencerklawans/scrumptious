package com.scrumptious.logic.ui;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * Adds an explicit link that the user has to click to login.
 */
@Tag("login-screen")
@JsModule("./src/views/login-screen.js")
@Route("")
public class LoginScreen extends PolymerTemplate<LoginScreen.LoginScreenModel>  {

    private static final String URL = "/oauth2/authorization/google";
	@Id("logoWrapper")
	private HorizontalLayout logoWrapper;
	@Id("signInWrapper")
	private HorizontalLayout signInWrapper;

    /**
     * This methods gets the user into google sign in page.
     */
    public LoginScreen() {
    	setLogo(); 
        Anchor googleLoginButton = new Anchor(URL, "Login with Google");
        googleLoginButton.getStyle().set("color", "#000000"); 
        googleLoginButton.getStyle().set("text-decoration", "none"); 
        googleLoginButton.getStyle().set("font-size", "12pt"); 
        signInWrapper.add(googleLoginButton);
    }
    
    /**
     * This model binds properties between LoginMain and login-main
     */
    public interface LoginScreenModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setLogo() {
    	Image logo = new Image("icons/updatedLogo.png", "scrumptious logo"); 
    	logo.setHeight("50px");
    	logo.setWidth("180px");
    	
    	logoWrapper.add(logo);
    }


}