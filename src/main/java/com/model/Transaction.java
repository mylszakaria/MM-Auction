package com.model;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Transaction {

    private int transId;
    private double transAmount;
    private User user;
    private Compensation comp;
    private Cart c;

    public Transaction(int transId, double transAmount, User user, Cart c) {
        this.transId = transId;
        this.transAmount = transAmount;
        this.user = user;
        this.c = c;
    }

    public Transaction(int transId, double transAmount, User user, Compensation comp) {
        this.transId = transId;
        this.transAmount = transAmount;
        this.user = user;
        this.comp = comp;
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

    public Compensation getComp() {
        return comp;
    }

    public void setComp(Compensation comp) {
        this.comp = comp;
    }

    public Cart getC() {
        return c;
    }

    public void setC(Cart c) {
        this.c = c;
    }
}
