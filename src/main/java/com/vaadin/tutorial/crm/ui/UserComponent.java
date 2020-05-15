<<<<<<< HEAD
package com.vaadin.tutorial.crm.ui;

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
}
=======
package com.vaadin.tutorial.crm.ui;

import com.vaadin.tutorial.crm.UserLoginEvent;

import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.textfield.TextField;

public class UserComponent extends FormLayout {
    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private Image image;

    public UserComponent() {
        firstName = new TextField();
        firstName.setReadOnly(true);
        lastName = new TextField();
        lastName.setReadOnly(true);
        email = new TextField();
        email.setReadOnly(true);
        image = new Image();
        addFormItem(firstName, "First name");
        addFormItem(lastName, "Last name");
        addFormItem(email, "Email address");
        addFormItem(image, "Image");
    }

    public void updateUser(UserLoginEvent login) {
        if (login == null) {
            firstName.setValue("");
            lastName.setValue("");
            email.setValue("");
            image.setSrc("");
        } else {
            firstName.setValue(login.getFirstName());
            lastName.setValue(login.getLastName());
            email.setValue(login.getToken());
            image.setSrc(login.getPictureUrl());
        }
    }
}
>>>>>>> kira
