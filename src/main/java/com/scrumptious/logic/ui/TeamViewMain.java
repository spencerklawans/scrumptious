package com.scrumptious.logic.ui;

import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.scrumptious.logic.backend.controller.ProjectController;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the team-view-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("team-view-main")
@JsModule("./src/views/team-view-main.js")
@Route(value = "team")
public class TeamViewMain extends PolymerTemplate<TeamViewMain.TeamViewMainModel> {

    @Id("header")
    private HeaderComponent header;
    @Id("sidebar")
    private SidebarComponent sidebar;
    @Id("teamView")
    private TeamView teamView;
    
    ProjectController projectController; 

    /**
     * Creates a new TeamViewMain.
     */
    public TeamViewMain(ProjectController pc) {
        // You can initialise any data required for the connected UI components here.
    	this.projectController = pc; 
        header.setLogo();
        sidebar.setNavButtons();
        header.setUserButton();
        teamView.populateTeam(); 
        sidebar.setTeamColor();
    }

    /**
     * This model binds properties between TeamViewMain and team-view-main
     */
    public interface TeamViewMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
