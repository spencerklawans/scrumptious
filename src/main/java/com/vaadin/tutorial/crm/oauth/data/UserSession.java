package com.vaadin.tutorial.crm.oauth.data;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
public class UserSession implements Serializable {

    public Long pid = -1L;

    public User getUser() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) authentication
                .getPrincipal();
        return new User(principal.getAttribute("given_name"),
                principal.getAttribute("family_name"),
                principal.getAttribute("email"),
                principal.getAttribute("picture"));
    }


    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext()
                .getAuthentication();
        return authentication != null;
    }

}
