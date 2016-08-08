package com.business.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;
    @Column
    private String userFirstName;
    @Column
    private String userLastName;
    @Column
    private String userRole;
    @OneToMany
    private List<Transaction> transHistory = new ArrayList<Transaction>();
    @ManyToMany
    private List<Auction> auctHistory;
    @Transient
    private Cart cart;
    @Embedded
    private Contact contact;
    @Embedded
    private Authentification auth;

    public User() {
        super();
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
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

    public List<Auction> getAuctHistory() {
        return auctHistory;
    }

    public void setAuctHistory(List<Auction> auctHistory) {
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

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Authentification getAuth() {
        return auth;
    }

    public void setAuth(Authentification auth) {
        this.auth = auth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUserId() != user.getUserId()) return false;
        if (getUserFirstName() != null ? !getUserFirstName().equals(user.getUserFirstName()) : user.getUserFirstName() != null)
            return false;
        if (getUserLastName() != null ? !getUserLastName().equals(user.getUserLastName()) : user.getUserLastName() != null)
            return false;
        if (getUserRole() != null ? !getUserRole().equals(user.getUserRole()) : user.getUserRole() != null)
            return false;
        if (getTransHistory() != null ? !getTransHistory().equals(user.getTransHistory()) : user.getTransHistory() != null)
            return false;
        if (auctHistory != null ? !auctHistory.equals(user.auctHistory) : user.auctHistory != null) return false;
        if (getCart() != null ? !getCart().equals(user.getCart()) : user.getCart() != null) return false;
        if (getContact() != null ? !getContact().equals(user.getContact()) : user.getContact() != null) return false;
        return !(getAuth() != null ? !getAuth().equals(user.getAuth()) : user.getAuth() != null);

    }

    public void addTransaction(Transaction t)
    {
        Transaction trans=null;
        while(this.transHistory.iterator().hasNext()){
            trans=this.transHistory.iterator().next();
            if(trans.getTransId()== t.getTransId())
            {
                System.out.println("Transaction already exists");
                trans.setTransAmount(t.getTransAmount());
                trans.setAuction(t.getAuction());
                trans.setUser(t.getUser());
                trans.setLimiteDate(t.getLimiteDate());
                break;
            }
        }
        this.transHistory.add(t);
    }
    public void addAuction(Auction a)
    {
        Auction auct=null;
        while(this.auctHistory.iterator().hasNext()){
            auct=this.auctHistory.iterator().next();
            if(auct.getAuctionId()== a.getAuctionId())
                System.out.println("Auction already exists");
        }
        this.auctHistory.add(a);
    }
}


