package com.vaadin.tutorial.crm.ui;

import com.vaadin.tutorial.crm.GoogleSignin;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route("")
public class LoginView extends Div {

    private final GoogleSignin signin;
    final String MY_GOOGLE_CLIENT_ID = "5379470553-vten4rndcb1loc0m21fravtih0jl9gqn.apps.googleusercontent.com";
    private final UserComponent userData;

    public LoginView() {
        if (MY_GOOGLE_CLIENT_ID  == null || MY_GOOGLE_CLIENT_ID.length() == 0) {
            Notification.show("Fill the client id: \n \n"
                    + "The attribute `clientId` is provided in your Google Developers Console\n"
                    + "(https://console.developers.google.com)");
        }
        FormLayout tweeks = new FormLayout();
        userData = new UserComponent();

        signin = new GoogleSignin(MY_GOOGLE_CLIENT_ID);
        signin.addLoginListener(event -> {
            userData.updateUser(event);
            Notification.show("Logged in");
        });

        signin.addLogoutListener(() -> {
            Notification.show("Logged out");
            userData.updateUser(null);
        });


        /*
        Some UI for look-and-feel testing
         */
        tweeks.add(getComboBox(GoogleSignin.Brand.class, GoogleSignin.Brand.values(), signin.getBrand()));
        tweeks.add(getComboBox(GoogleSignin.Theme.class, GoogleSignin.Theme.values(), signin.getTheme()));
        tweeks.add(getComboBox(GoogleSignin.Width.class, GoogleSignin.Width.values(), signin.getWidth()));
        tweeks.add(getComboBox(GoogleSignin.Height.class, GoogleSignin.Height.values(), signin.getHeight()));
        Checkbox raised = new Checkbox("Raised");
        raised.setValue(signin.getRaised());
        raised.addValueChangeListener(event -> {
            signin.setRaised(event.getValue());
        });
        tweeks.add(raised);
        Checkbox autoLogout = new Checkbox("auto logout");
        autoLogout.setValue(signin.isAutoLogout());
        autoLogout.addValueChangeListener(event -> {
            signin.setAutoLogout(event.getValue());
        });
        tweeks.add(autoLogout);
        Button logout = new Button("Logout");
        logout.addClickListener(buttonClickEvent -> signin.logout());
        tweeks.add(logout);
        add(new H2("Login button options"));
        add(tweeks);
        add(new Hr());
        add(signin);
        add(new Hr());
        add(new H2("Last logged user data"));
        add(userData);
        add(new Hr());
    }

    public <T extends Object> ComboBox<T> getComboBox(Class<T> type, T[] values, T defaultValue) {
        ComboBox<T> comboBox = new ComboBox<>(type.getSimpleName());
        comboBox.setItems(values);
        comboBox.setValue(defaultValue);
        comboBox.addValueChangeListener(event -> {
            handleSelect(event.getValue());
        });
        return comboBox;
    }

    private <T extends Object> void handleSelect(T value) {
        if (value instanceof GoogleSignin.Height) {
            signin.setHeight((GoogleSignin.Height)value);
        } else if (value instanceof GoogleSignin.Width) {
            signin.setWidth((GoogleSignin.Width)value);
        } else if (value instanceof GoogleSignin.Theme) {
            signin.setTheme((GoogleSignin.Theme)value);
        } else if (value instanceof GoogleSignin.Brand) {
            signin.setBrand((GoogleSignin.Brand)value);
        }
    }
}
