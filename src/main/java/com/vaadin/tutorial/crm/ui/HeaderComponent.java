package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;

/**
 * A Designer generated component for the header-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("header-component")
@JsModule("./src/views/header-component.js")
public class HeaderComponent extends PolymerTemplate<HeaderComponent.HeaderComponentModel> {

    @Id("logoWrapper")
	private HorizontalLayout logoWrapper;

	/**
     * Creates a new HeaderComponent.
     */
    public HeaderComponent() {
        // You can initialise any data required for the connected UI components here.    	
    }

    /**
     * This model binds properties between HeaderComponent and header-component
     */
    public interface HeaderComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    public void setLogo() {
    	Image logo = new Image("icons/updatedLogo.png", "scrumptious logo"); 
    	logo.setHeight("50px");
    	logo.setWidth("180px");
    	
    	logoWrapper.add(logo);
    }
}
