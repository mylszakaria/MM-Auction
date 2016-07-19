package com.business.model;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column
    private String userFirstName;
    @Column
    private String userLastName;
    @Column
    private String userRole;
    @OneToMany
    private List<Transaction> transHistory;
    @ManyToMany
    private List<Auction> auctHistory;
    @OneToOne
    private Cart cart;
    @Embedded
    private Contact contact;
    @Embedded
    private Authentification auth;

    public User(int userId, String userFirstName, String userLastName, String userRole, List<Transaction> transHistory, List<Auction> auctHistory, Cart cart, Contact conctact, Authentification auth) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userRole = userRole;
        this.transHistory = transHistory;
        this.auctHistory = auctHistory;
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

    public List<Auction> getauctHistory() {
        return auctHistory;
    }

    public void setCompHistory(List<Compensation> compHistory) {
        this.auctHistory = auctHistory;
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
