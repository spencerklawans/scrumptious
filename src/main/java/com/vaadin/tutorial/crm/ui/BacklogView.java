package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.TicketController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

/**
 * A Designer generated component for the backlog-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-view")
@JsModule("./src/views/backlog-view.js")
@Route(value = "backlog")
public class BacklogView extends PolymerTemplate<BacklogView.BacklogViewModel> {

	@Id("sidebar")
	private SidebarComponent sidebar;
	@Id("header")
	private HeaderComponent header;
	@Id("addComponent")
	private AddBacklogComponent addComponent;

	private ProjectController projectController;
	UserSessionController usc;
	UserDataController udc;
	TicketController tc; 
	
	@Id("backlogWrapper")
	private HorizontalLayout backlogWrapper;
	/**
     * Creates a new BacklogView.
     */

    public BacklogView(ProjectController projectController, UserSessionController usc, UserDataController udc, 
    		TicketController tc) {
        // You can initialise any data required for the connected UI components here.
		this.projectController = projectController;
    	sidebar.setNavButtons();
    	header.setLogo();
    	header.setUserButton();
    	addComponent.setNavButtons();

		this.udc = udc;
		this.usc = usc;
		this.tc = tc; 
		if(usc.getPid() == null) {
	//    	add null check if there is no project associated w the session.
			Notification.show("No project associated w/ session");
		}
		else {
			this.populateBacklog();
		}
		sidebar.setBacklogColor(); 
    }
    public void populateBacklog() {
    	Long pid = usc.getPid(); 
    	List<BacklogMiniComponent> fullBacklog = projectController.buildBacklogComponents(pid);
    	List<BacklogMiniComponent> highPriority = fullBacklog.stream()
    											.filter(bmc -> bmc.getPriority().equals("HIGH"))
    											.collect(Collectors.toList());
    	List<BacklogMiniComponent> medPriority = fullBacklog.stream()
				.filter(bmc -> bmc.getPriority().equals("MEDIUM"))
				.collect(Collectors.toList());
    	List<BacklogMiniComponent> lowPriority = fullBacklog.stream()
				.filter(bmc -> bmc.getPriority().equals("LOW"))
				.collect(Collectors.toList());
    	
		for (BacklogMiniComponent bmc : highPriority) {
			bmc.setPriorityListener(e -> generatePopUp(bmc.getTicketNum()));
			backlogWrapper.add(bmc);
		}
		
		for (BacklogMiniComponent bmc : medPriority) {
			bmc.setPriorityListener(e -> generatePopUp(bmc.getTicketNum()));
			backlogWrapper.add(bmc);
		}
		
		for (BacklogMiniComponent bmc : lowPriority) {
			bmc.setPriorityListener(e -> generatePopUp(bmc.getTicketNum()));
			backlogWrapper.add(bmc);
		}
	}

    /**
     * This model binds properties between BacklogView and backlog-view
     */
    public interface BacklogViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void generatePopUp(int index) {
    	EditTicket et = new EditTicket(projectController, usc, udc); 
    	Long pid = usc.getPid(); 
    	Dialog dialog = new Dialog(); 
    	
    	et.setTextDetails(tc.getTicketTitle(index, pid), tc.getTicketDescription(index, pid));
    	et.setPriority(tc.getPriority(index, pid));
    	
    	et.getCancelButton().addClickListener(e -> {
    		dialog.close(); 
    	}); 
    	
    	et.getUpdateButton().addClickListener(e -> {
    		tc.updateTicket(et.getTitle(), et.getDescription(), et.getDateDue(), 
    				et.getPriority(), et.getStatus(), et.getAssignees(), index, pid);
    		dialog.close(); 
    		UI.getCurrent().getPage().reload();
    	});
    	
    	dialog.add(et);
    	dialog.open(); 
    }
}
