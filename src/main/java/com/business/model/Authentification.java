package com.business.model;

/**
 * Created by zakaria on 18/07/2016.
 */

public class Authentification {

    private User user;
    private String login;
    private String password;
    public Authentification() {
    }

    public Authentification(User user, String login, String password) {
        this.user = user;
        this.login = login;
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
