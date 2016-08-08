package com.business.model;

import javax.persistence.*;


/**
 * Created by zakaria on 18/07/2016.
 */
@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transId;
    @Column
    private double transAmount;
    @ManyToOne
    private User user;
    @ManyToOne
    private Auction auction;
    @Column
    private String limiteDate;


    public Transaction() {
        super();
    }

    public String  getLimiteDate() {
        return limiteDate;
    }

    public void setLimiteDate(String limiteDate) {
        this.limiteDate = limiteDate;
    }

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
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
