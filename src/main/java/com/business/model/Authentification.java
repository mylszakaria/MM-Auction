package com.business.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by zakaria on 18/07/2016.
 */

@Embeddable
public class Authentification {

    @Column
    private String login;
    @Column
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
