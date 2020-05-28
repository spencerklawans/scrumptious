package com.vaadin.tutorial.crm;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

@DomEvent("google-signout-attempted")
public class InternalSignOutEvent extends ComponentEvent<GoogleSignin> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 820875449565421675L;

	public InternalSignOutEvent(GoogleSignin source, boolean fromClient) {
        super(source, fromClient);
    }
}
