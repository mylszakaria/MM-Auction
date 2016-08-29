package com.business.model;

import javax.persistence.*;

/**
 * Created by zakaria on 29/08/2016.
 */

@Entity
public class AuctionWinner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    @ManyToOne
    private AuctionProduct prod;
    @ManyToOne
    private User user;
    @Column
    private double bid;

    public AuctionWinner() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public AuctionProduct getProd() {
        return prod;
    }

    public void setProd(AuctionProduct prod) {
        this.prod = prod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }
}
