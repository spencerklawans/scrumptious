package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.oauth.data.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.button.Button;


/**
 * A Designer generated component for the team-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("team-view")
@JsModule("./src/views/team-view.js")
public class TeamView extends PolymerTemplate<TeamView.TeamViewModel> {

    @Id("root")
    private VerticalLayout root;

    @Autowired
    UserSession userSession = new UserSession();
    private ProjectController projectController;
    private UserSessionController usc;

	@Id("inviteMember")
	private Button inviteMember;

	@Id("teamWrapper")
	private HorizontalLayout teamWrapper;




    /**
     * Creates a new TeamView.
     */
    public TeamView(ProjectController projectController, UserSessionController usc) {
        this.projectController = projectController;
        this.usc = usc;
        generatePopup();
    }

    public void generatePopup()
    {
        VerticalLayout layout = new VerticalLayout();
        HorizontalLayout hLayout = new HorizontalLayout();
        Dialog dialog = new Dialog();
        Button add = new Button("Add Member");
        Button cancel = new Button("Cancel");
        setButtonStyle(add); 
        setButtonStyle(cancel); 
        TextField email = new TextField();
        email.setPlaceholder("Email");
        layout.add(new Label("Add a Team Member"));
        layout.add(email);
        hLayout.add(cancel);
        hLayout.add(add);
        layout.add(hLayout);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        dialog.add(layout);
        dialog.setWidth("900");

        add.addClickListener(event -> {
            projectController.addMember(email.getValue(), usc.getPid());
            dialog.close();
            UI.getCurrent().getPage().reload();
        });

        cancel.addClickListener(event -> dialog.close());
        inviteMember.addClickListener(event -> dialog.open());
    }

    public void populateTeam() {
        for (UserComponent userComponent:
                projectController.buildUserComponents()) {
            teamWrapper.add(userComponent);
            
        }
    }
    
    public void setButtonStyle(Button b) {
    	b.getStyle().set("background-color", "#FED766");
    	b.getStyle().set("border-radius", "10px");
    	b.getStyle().set("color", "#000000");
    	b.getStyle().set("box-shadow", " var(--lumo-box-shadow-s)");
    }

    /**
     * This model binds properties between TeamView and team-view
     */
    public interface TeamViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
