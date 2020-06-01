package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.backend.controller.ProjectController;
import com.vaadin.tutorial.crm.backend.controller.UserDataController;
import com.vaadin.tutorial.crm.backend.controller.UserSessionController;
import com.vaadin.tutorial.crm.backend.entity.Project;
import com.vaadin.tutorial.crm.oauth.data.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import com.vaadin.flow.component.html.Image;
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
    @Id("columnOne")
    private VerticalLayout columnOne;
    @Id("columnTwo")
    private VerticalLayout columnTwo;
    @Id("columnThree")
    private VerticalLayout columnThree;
    private ProjectController projectController;
    private UserSessionController usc;

	@Id("inviteMember")
	private Button inviteMember;




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
        Dialog dialog = new Dialog();
        Button add = new Button("Add Member");
        TextField email = new TextField("enter email");
        dialog.add(new Label("Add a team member"));
        dialog.add(email);
        dialog.add(add);

        add.addClickListener(event -> {
            projectController.addMember(email.getValue(), usc.getPid());
            dialog.close();
            UI.getCurrent().getPage().reload();
        });
        inviteMember.addClickListener(event -> dialog.open());
    }

    public int populateTeam() {
        int i = 0;
        for (UserComponent userComponent:
                projectController.buildUserComponents()) {
            if(userComponent != null) {
                switch (i % 3) {
                    case 0:
                        columnOne.add(userComponent);
                        break;
                    case 1:
                        columnTwo.add(userComponent);
                        break;
                    case 2:
                        columnThree.add(userComponent);
                        break;
                    default:
                        return 1;
                }
                i += 1;
            }
        }
        return 0;
    }

    /**
     * This model binds properties between TeamView and team-view
     */
    public interface TeamViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
//    static get properties() {
//        }
//    }
}
