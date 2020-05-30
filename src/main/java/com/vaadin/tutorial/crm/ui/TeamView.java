package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
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
    @Id("2nd column")
    private VerticalLayout _2ndColumn;



    @Id("3rd Column")
    private VerticalLayout _3rdColumn;
    @Id("1st Column")
    private VerticalLayout _1stColumn;
    @Autowired
    UserSession userSession = new UserSession();
    /**
     * Creates a new TeamView.
     */
    public TeamView() {
        // You can initialise any data required for the connected UI components here.
//        for each user in current project:
//                add component showing them as below
        UserComponent me = new UserComponent();
        me.setDetails(userSession.getUser().getFirstName() + " " + userSession.getUser().getLastName());
        me.setIcon(new Image(userSession.getUser().getPicture(),"UserIcon"));
        _2ndColumn.add(me);
//        _2ndColumn.add(new Image(userSession.getUser().getPicture(), "UserIcon"));

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
