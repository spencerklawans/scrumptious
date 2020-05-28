package com.vaadin.tutorial.crm.ui;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.tutorial.crm.GoogleSignin;
import com.vaadin.tutorial.crm.GoogleSignin.Height;
import com.vaadin.tutorial.crm.GoogleSignin.Theme;
import com.vaadin.tutorial.crm.GoogleSignin.Width;
import com.vaadin.tutorial.crm.backend.entity.Database;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the login-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-main")
@JsModule("./src/views/login-main.js")
@Route(value = "")
public class LoginMain extends PolymerTemplate<LoginMain.LoginMainModel> {
	private final GoogleSignin signin;
	final static String MY_GOOGLE_CLIENT_ID = "5379470553-vten4rndcb1loc0m21fravtih0jl9gqn.apps.googleusercontent.com";

    @Id("logoWrapper")
	private HorizontalLayout logoWrapper;
	@Id("signInWrapper")
	private HorizontalLayout signInWrapper;
	
    Database dbc;
	/**
     * Creates a new LoginMain.
     */
    public LoginMain(Database dbc) {
        // You can initialise any data required for the connected UI components here.
    	setLogo(); 
    	signin = new GoogleSignin(MY_GOOGLE_CLIENT_ID);
    	signin.setHeight(Height.TALL);
    	signin.setWidth(Width.WIDE);
    	signin.setTheme(Theme.LIGHT);
    	this.dbc = dbc;
        signin.addLoginListener(event -> {
            dbc.updateUser(event);
        });
        signInWrapper.add(signin);
    }
        
    /**
     * This model binds properties between LoginMain and login-main
     */
    public interface LoginMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setLogo() {
    	Image logo = new Image("icons/updatedLogo.png", "scrumptious logo"); 
    	logo.setHeight("50px");
    	logo.setWidth("180px");
    	
    	logoWrapper.add(logo);
    }
}
