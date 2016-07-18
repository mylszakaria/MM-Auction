package com.business.model;

import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */

public class User {

    private int userId;
    private String userFirstName;
    private String userLastName;
    private String userRole;
    private List<Transaction> transHistory;
    private List<Compensation> compHistory;
    private Cart cart;
    private Contact contact;
    private Authentification auth;

    public User(int userId, String userFirstName, String userLastName, String userRole, List<Transaction> transHistory, List<Compensation> compHistory, Cart cart, Contact conctact, Authentification auth) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userRole = userRole;
        this.transHistory = transHistory;
        this.compHistory = compHistory;
        this.cart = cart;
        this.contact = conctact;
        this.auth = auth;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public List<Transaction> getTransHistory() {
        return transHistory;
    }

    public void setTransHistory(List<Transaction> transHistory) {
        this.transHistory = transHistory;
    }

    public List<Compensation> getCompHistory() {
        return compHistory;
    }

    public void setCompHistory(List<Compensation> compHistory) {
        this.compHistory = compHistory;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Contact getContact() {
        return contact;
    }

    public void setConctact(Contact conctact) {
        this.contact = conctact;
    }

    public Authentification getAuth() {
        return auth;
    }

    public void setAuth(Authentification auth) {
        this.auth = auth;
    }
}
