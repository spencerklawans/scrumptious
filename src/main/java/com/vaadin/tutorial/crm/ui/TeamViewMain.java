package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
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
public class TeamViewMain extends PolymerTemplate<TeamViewMain.TeamViewMainModel> {

    /**
     * Creates a new TeamViewMain.
     */
    public TeamViewMain() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between TeamViewMain and team-view-main
     */
    public interface TeamViewMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
