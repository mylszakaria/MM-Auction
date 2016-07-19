package com.business.model;

/**
 * Created by zakaria on 18/07/2016.
 */

public class Authentification {

    private String login;
    private String password;
    public Authentification() {
    }

    public Authentification(String login, String password) {

        this.login = login;
        this.password = password;
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
