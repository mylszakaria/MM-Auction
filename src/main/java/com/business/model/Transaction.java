package com.business.model;

import org.hibernate.boot.registry.selector.StrategyRegistration;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zakaria on 18/07/2016.
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int transId;
    @Column
    private double transAmount;
    @ManyToOne
    private User user;
    @ManyToOne
    private Auction auction;
    @Column
    private Date limiteDate;

    //Constructeur pour payer  la compensation
    public Transaction(int transId, double transAmount, User user, Auction auction) {
        this.transId = transId;
        this.transAmount = transAmount;
        this.user = user;
        this.auction = auction;
    }

    //Constructeur pour acheter les produits du panier
    public Transaction(int transId, double transAmount, User user) {
        this.transId = transId;
        this.transAmount = transAmount;
        this.user = user;
    }

    public Transaction() {
    }

    public Date getLimiteDate() {
        return limiteDate;
    }

    public void setLimiteDate(Date limiteDate) {
        this.limiteDate = limiteDate;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }


}
