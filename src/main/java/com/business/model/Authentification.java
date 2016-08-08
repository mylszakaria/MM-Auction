package com.business.model;
import com.utilities.Encryptor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by zakaria on 18/07/2016.
 */

@Embeddable
public class Authentification {

    @Column(unique = true)
    private String email;
    @Column(nullable=false)
    private String password;

    public Authentification() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Encryptor.encrypte(password);
    }
}
