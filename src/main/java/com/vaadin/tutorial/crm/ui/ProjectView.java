package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the main-project-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("project-view")
@JsModule("./src/views/project-view.js")
@Route(value = "projects")
public class ProjectView extends PolymerTemplate<ProjectView.ProjectViewModel> {

    @Id("header")
	private HeaderComponent header;

	/**
     * Creates a new MainProjectView.
     */
    public ProjectView() {
        // You can initialise any data required for the connected UI components here.
    	header.setLogo();
    }

    /**
     * This model binds properties between MainProjectView and main-project-view
     */
    public interface ProjectViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
