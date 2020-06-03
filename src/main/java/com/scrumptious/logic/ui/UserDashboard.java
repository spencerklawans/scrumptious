package com.scrumptious.logic.ui;

import com.scrumptious.logic.backend.controller.UserSessionController;
import com.scrumptious.logic.backend.entity.UserData;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.listbox.ListBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.scrumptious.logic.backend.controller.ProjectController;
import com.scrumptious.logic.backend.controller.TicketController;
import com.scrumptious.logic.backend.controller.UserDataController;
import com.scrumptious.logic.backend.entity.Ticket;

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
	@Id("projectListBox")
	private ListBox<String> projectListBox;
	@Id("toProjectsButton")
	private Button toProjectsButton;
	@Id("ticketListBox")
	private ListBox<String> ticketListBox;
	@Id("toTicketsButton")
	private Button toTicketsButton;
	@Id("noteField")
	private TextArea noteField;

	@Id("name")
	private Button name;
	@Id("email")
	private Button email;
	@Id("userProfilePic")
	private Button userProfilePic;


	UserSessionController usc;
	
	UserDataController udc;

	ProjectController pc;

	TicketController tc;

	@Id("saveNotesButton")
	private Button saveNotesButton;
	@Id("currProject")
	private Button currProject;

	/**
     * Creates a new UserDashboard.
     */
    public UserDashboard(UserDataController udc, UserSessionController usc,
						 ProjectController pc, TicketController tc) {
        // You can initialise any data required for the connected UI components here.
    	this.udc = udc;
    	this.usc = usc;
    	this.pc = pc;
    	this.tc = tc;
    	setPageButtons();
    	populatePage();
    	header.setLogo();
    	if (udc.getFromEmail(usc.getEmail()) == null)
    	{
    		udc.addUser(usc.getEmail());
    	}

    	addListeners();

    }

    public void addListeners()
	{
		saveNotesButton.addClickListener(e -> {
			UserData currUser = udc.getFromEmail(usc.getEmail());
			udc.getFromEmail(usc.getEmail()).setNotes(noteField.getValue());
			currUser.setNotes(noteField.getValue());
			udc.saveUser(currUser);
			Notification.show("Notes saved!");
		});
	}

    public void populatePage()
	{
		List<Long> projects = udc.getFromEmail(usc.getEmail()).getProjects();
		for (Long project : projects) {
			ListItem item = new ListItem();
			item.setText(pc.findPid(project).getName());
			projectListBox.add(item);
		}
		
		List<Ticket> tickets = tc.findTicketsByPid(usc.getPid());
		for (Ticket ticket : tickets) {
			if (ticket.getAssignees().contains(usc.getEmail())) {
				ListItem newTicket = new ListItem();
				newTicket.setText(ticket.getTitle());
				ticketListBox.add(newTicket);
			}
		}
		
		noteField.setValue(udc.getFromEmail(usc.getEmail()).getNotes());
	}

    /**
     * This model binds properties between UserDashboard and user-dashboard
     */
    public interface UserDashboardModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setPageButtons() {
    	name.setText(usc.getFullName());
    	email.setText(usc.getEmail());
    	currProject.setText(pc.findPid(usc.getPid()).getName()); 
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
    }

	public static long hash(String string) {
		long h = 1125899906842597L; // prime
		int len = string.length();

		for (int i = 0; i < len; i++) {
			h = 31 * h + string.charAt(i);
		}
		return h;
	}
}
