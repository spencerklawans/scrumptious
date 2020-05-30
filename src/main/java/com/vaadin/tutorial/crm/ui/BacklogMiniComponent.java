package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.tutorial.crm.backend.entity.StatusEnum;

/**
 * A Designer generated component for the backlog-mini-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-mini-component")
@JsModule("./src/views/backlog-mini-component.js")
public class BacklogMiniComponent extends PolymerTemplate<BacklogMiniComponent.BacklogMiniComponentModel> {

    @Id("title")
    private Button title;
    @Id("priority")
    private Button priority;

    /**
     * Creates a new BacklogMiniComponent.
     */
    public BacklogMiniComponent() {
        // You can initialise any data required for the connected UI components here.
    }
    public BacklogMiniComponent(String title, StatusEnum status) {
        this.title.setText(title);
        this.priority.setText(status.name());

    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

    public void setPriority(StatusEnum status) {
        this.priority.setText(status.name());
//        TODO: change style to green / yellow / red
    }

    /**
     * This model binds properties between BacklogMiniComponent and backlog-mini-component
     */
    public interface BacklogMiniComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
