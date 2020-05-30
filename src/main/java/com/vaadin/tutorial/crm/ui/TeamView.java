package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
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

    /**
     * Creates a new TeamView.
     */
    public TeamView(ProjectController projectController) {
        this.projectController = projectController;
        // You can initialise any data required for the connected UI components here.
//        for each user in current project:
//                add component showing them as below

        UserComponent me = new UserComponent();
        me.setDetails(userSession.getUser().getFirstName() + " " + userSession.getUser().getLastName());
//        _2ndColumn.add(new Image(userSession.getUser().getPicture(), "UserIcon"));

    }
    public int populateBacklogTeam() {
        int i = 0;
        for (UserComponent userComponent:
                projectController.buildUserComponents()) {
            switch (i % 3){
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
        return 0;
    }
    public void setNavButtons() {
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
