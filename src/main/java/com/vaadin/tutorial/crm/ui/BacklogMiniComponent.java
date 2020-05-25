package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the backlog-mini-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-mini-component")
@JsModule("./src/views/backlog-mini-component.js")
public class BacklogMiniComponent extends PolymerTemplate<BacklogMiniComponent.BacklogMiniComponentModel> {

    /**
     * Creates a new BacklogMiniComponent.
     */
    public BacklogMiniComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between BacklogMiniComponent and backlog-mini-component
     */
    public interface BacklogMiniComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
