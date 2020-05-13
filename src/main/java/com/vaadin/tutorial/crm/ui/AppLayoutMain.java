package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * A Designer generated component for the app-layout-main template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("app-layout-main")
@JsModule("./src/views/app-layout-main.js")
@Route("")
public class AppLayoutMain extends PolymerTemplate<AppLayoutMain.AppLayoutMainModel> implements RouterLayout {

    @Id("header")
	private HorizontalLayout header;
	@Id("userDashButton")
	private Button userDashButton;
	@Id("userButtonWrapper")
	private HorizontalLayout userButtonWrapper;
	@Id("logoWrapper")
	private HorizontalLayout logoWrapper;
	@Id("navButtonBacklog")
	private Button navButtonBacklog;
	@Id("lowerWrapper")
	private HorizontalLayout lowerWrapper;

	/**
     * Creates a new AppLayoutMain.
     */
    public AppLayoutMain() {
        // You can initialise any data required for the connected UI components here.
    	
    	//set image
    	Image logo = new Image("icons/updatedLogo.png", "scrumptious logo"); 
    	logo.setHeight("50px");
    	logo.setWidth("180px");
    	logoWrapper.add(logo);
    	
    	navButtonBacklog.addClickListener(e -> {
    		navButtonBacklog.getUI().ifPresent(ui -> ui.navigate("backlog")); 
    	});
    	
    	VerticalLayout content = new VerticalLayout();
    	lowerWrapper.add(content);
    	content.setFlexGrow(1, lowerWrapper);
    
    }

    /**
     * This model binds properties between AppLayoutMain and app-layout-main
     */
    public interface AppLayoutMainModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    
    
}
