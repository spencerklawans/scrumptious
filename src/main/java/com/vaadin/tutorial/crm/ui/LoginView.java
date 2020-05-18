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

@Route("sampleLogin")
public class LoginView extends Div {

    private final GoogleSignin signin;
    final String MY_GOOGLE_CLIENT_ID = "5379470553-vten4rndcb1loc0m21fravtih0jl9gqn.apps.googleusercontent.com";

    public LoginView() {
        signin = new GoogleSignin(MY_GOOGLE_CLIENT_ID);
        add(signin);
    }
}
