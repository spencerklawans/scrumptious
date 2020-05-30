package com.vaadin.tutorial.crm.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the user-component template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-component")
@JsModule("./src/views/user-component.js")
public class UserComponent extends PolymerTemplate<UserComponent.UserComponentModel> {

    @Id("userButton")
    private Button userButton;
    @Id("UserIcon")
    private Button userIcon;

    /**
     * Creates a new UserComponent.
     */
    public UserComponent() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between UserComponent and user-component
     */
    public interface UserComponentModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
    public void setDetails(String name) {
        userButton.setText(name);
    }
    public void setIcon(Image icon) {
        icon.setHeight("40px");
        icon.setWidth("40px");
        userIcon.setIcon(icon);
    }

}