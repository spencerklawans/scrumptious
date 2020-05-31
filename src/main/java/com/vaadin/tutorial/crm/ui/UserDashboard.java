package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.dom.Element;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.backend.entity.Ticket;
import com.vaadin.tutorial.crm.backend.repository.UserDataRepository;
import com.vaadin.tutorial.crm.oauth.data.UserSession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


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
	private ListBox<String> projectListBox;
	@Id("toProjectsButton")
	private Button toProjectsButton;
	@Id("ticketListBox")
	private ListBox<String> ticketListBox;
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


	UserSessionController usc;
	
	UserDataController udc;

	ProjectController pc;

	/**
     * Creates a new UserDashboard.
     */
    public UserDashboard(UserDataController udc, UserSessionController usc, ProjectController pc) {
        // You can initialise any data required for the connected UI components here.
    	this.udc = udc;
    	this.usc = usc;
    	this.pc = pc;
    	setPageButtons();
    	populatePage();
    	header.setLogo();
    	if (udc.getFromEmail(usc.getEmail()) == null)
    	{
    		udc.addUser(usc.getEmail());
    	}
    	for (Long project_id : udc.getFromEmail(usc.getEmail()).getProjects())
    		System.out.println((project_id.toString()));

    }

    public void populatePage()
	{
		for(Long pid : udc.getFromEmail(usc.getEmail()).getProjects()) {
			ListItem item = new ListItem();
			item.setText(pc.findPid(pid).getName());
			projectListBox.add(item);
			for(Ticket t : pc.findPid(pid).getTickets())
			{
				if(t.getAssignees().contains(usc.getEmail()))
				{
					ListItem newTicket = new ListItem();
					newTicket.setText(t.getTitle());
					ticketListBox.add(newTicket);
				}
			}
		}

	}

    /**
     * This model binds properties between UserDashboard and user-dashboard
     */
    public interface UserDashboardModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setPageButtons() {
		usc.setPid(hash(usc.getFirstName()));
    	name.setText(usc.getFullName());
		Image icon = new Image(usc.getPicUrl(),"UserIcon");
		icon.setHeight("150px");
		icon.setWidth("150px");
		userProfilePic.setIcon(icon);
    	toProjectsButton.addClickListener(e ->
    		toProjectsButton.getUI()
    						.ifPresent(ui -> ui.navigate("projects"))
    	);
    	
    	toTicketsButton.addClickListener(e ->
    		toTicketsButton.getUI().ifPresent(ui -> ui.navigate("tickets"))
    	);
    	System.out.println("PID: " + usc.getPid());
    	String p = Long.toString(usc.getPid());
    	editProfileButton.addClickListener(event -> Notification.show(p));
    	
    }
    
    public void addToNotes() {
    }

	public static long hash(String string) {
		long h = 1125899906842597L; // prime
		int len = string.length();

		for (int i = 0; i < len; i++) {
			h = 31*h + string.charAt(i);
		}
		return h;
	}
    
}
