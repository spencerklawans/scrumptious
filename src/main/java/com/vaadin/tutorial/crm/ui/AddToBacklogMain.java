package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the add-to-backlog-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("add-to-backlog-main")
@JsModule("./src/views/add-to-backlog-main.js")
public class AddToBacklogMain extends PolymerTemplate<AddToBacklogMain.AddToBacklogMainModel> {

    /**
     * Creates a new AddToBacklogMain.
     */
    public AddToBacklogMain() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between AddToBacklogMain and add-to-backlog-main
     */
    public interface AddToBacklogMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
