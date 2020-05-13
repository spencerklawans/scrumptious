package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;

/**
 * A Designer generated component for the main-project-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-project-view")
@JsModule("./src/views/main-project-view.js")
@Route(value = "projects")
public class MainProjectView extends PolymerTemplate<MainProjectView.MainProjectViewModel> {

    /**
     * Creates a new MainProjectView.
     */
    public MainProjectView() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between MainProjectView and main-project-view
     */
    public interface MainProjectViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
