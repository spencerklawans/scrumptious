package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Optional;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.tutorial.crm.ui.SidebarComponent;

/**
 * A Designer generated component for the backlog-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("backlog-view")
@JsModule("./src/views/backlog-view.js")
@Route(value = "backlog")
public class BacklogView extends PolymerTemplate<BacklogView.BacklogViewModel> {

	@Id("sidebar")
	private SidebarComponent sidebar;
	@Id("header")
	private HeaderComponent header;

	/**
     * Creates a new BacklogView.
     */
    public BacklogView() {
        // You can initialise any data required for the connected UI components here.
    	sidebar.setNavButtons();
    	header.setLogo();
    	header.setUserButton();
  
    }

    /**
     * This model binds properties between BacklogView and backlog-view
     */
    public interface BacklogViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
