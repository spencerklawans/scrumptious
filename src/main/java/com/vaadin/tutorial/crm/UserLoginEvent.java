package com.vaadin.tutorial.crm;

public class UserLoginEvent {
    private String userId;
    private String email;
    private String name;
    private String pictureUrl;
    private String locale;
    private String firstName;
    private String lastName;
    private String token;

    public UserLoginEvent(String userId, String email, String name, String pictureUrl, String locale, String firstName,
            String lastName, String token) {
    	this.userId = userId;
        this.email = email;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.locale = locale;
        this.firstName = firstName;
        this.lastName = lastName;
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getLocale() {
        return locale;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    /**
     * Thhe login-token, retrieved from succesful login
     *
     * @return
     */
    public String getToken() {
        return token;
    }
}
