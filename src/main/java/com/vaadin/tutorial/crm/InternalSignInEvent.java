package com.vaadin.tutorial.crm;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

/**
 * Custom event to capture (internally) google sign in events
 */
@DomEvent("google-signin-aware-success")
public class InternalSignInEvent extends ComponentEvent<GoogleSignin> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 4749171315834504728L;
	private String idToken;

    public InternalSignInEvent(GoogleSignin source, boolean fromClient,
            @EventData("event.detail.id_token") String idToken) {
        super(source, fromClient);
        this.idToken = idToken;
    }

    public String getIdToken() {
        return idToken;
    }
}
