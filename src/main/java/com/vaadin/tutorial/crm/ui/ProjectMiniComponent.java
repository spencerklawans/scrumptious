package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the project-mini-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("project-mini-component")
@JsModule("./src/views/project-mini-component.js")
public class ProjectMiniComponent extends PolymerTemplate<ProjectMiniComponent.ProjectMiniComponentModel> {

    /**
     * Creates a new ProjectMiniComponent.
     */
    public ProjectMiniComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between ProjectMiniComponent and project-mini-component
     */
    public interface ProjectMiniComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
