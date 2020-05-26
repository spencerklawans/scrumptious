package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

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
    @Id("2nd column")
    private VerticalLayout _2ndColumn;

    /**
     * Creates a new TeamView.
     */
    public TeamView() {
        // You can initialise any data required for the connected UI components here.
        for (int i = 0; i < 2; i++) {
            UserComponent user = new UserComponent();
            user.setDetails("My Name");
            _2ndColumn.add(user);
        }
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
