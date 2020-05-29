package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.tutorial.crm.oauth.data.UserSession;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A Designer generated component for the user-dashboard template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-dashboard")
@JsModule("./src/views/user-dashboard.js")
@Route(value = "dashboard")
public class UserDashboard extends PolymerTemplate<UserDashboard.UserDashboardModel> {



    @Id("header")
	private HeaderComponent header;
	@Id("editProfileButton")
	private Button editProfileButton;
	@Id("projectListBox")
	private Element projectListBox;
	@Id("toProjectsButton")
	private Button toProjectsButton;
	@Id("ticketListBox")
	private Element ticketListBox;
	@Id("toTicketsButton")
	private Button toTicketsButton;
	@Id("notesField")
	private HorizontalLayout notesField;
	@Id("name")
	private Button name;
	@Id("role")
	private Button role;
	@Id("email")
	private Button email;
	@Id("userProfilePic")
	private Button userProfilePic;


	@Autowired
	UserSession userSession = new UserSession();

	/**
     * Creates a new UserDashboard.
     */
    public UserDashboard() {
        // You can initialise any data required for the connected UI components here.
    	setPageButtons(); 
    	header.setLogo();
    }

    /**
     * This model binds properties between UserDashboard and user-dashboard
     */
    public interface UserDashboardModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setPageButtons() {
    	name.setText(userSession.getUser().getFirstName() + " " + userSession.getUser().getLastName());
		Image icon = new Image(userSession.getUser().getPicture(),"UserIcon");
		icon.setHeight("150px");
		icon.setWidth("150px");
		userProfilePic.setIcon(icon);
    	toProjectsButton.addClickListener(e ->
    		toProjectsButton.getUI().ifPresent(ui -> ui.navigate("projects"))
    	);
    	
    	toTicketsButton.addClickListener(e ->
    		toTicketsButton.getUI().ifPresent(ui -> ui.navigate("tickets"))
    	);
    	
    }
    
    public void addToNotes() {
    }
    
}
