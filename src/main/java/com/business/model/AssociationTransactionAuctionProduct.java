package com.business.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zakaria on 19/07/2016.
 */
@Entity
public class AssociationTransactionAuctionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  long id;
    @Transient
    private Cart cart;
    @OneToOne
    private User user;
    @ManyToOne
    private AuctionProduct auctProduct;
    @Column
    private double highestBid;
    @ManyToOne
    private Transaction trans;

    public AssociationTransactionAuctionProduct() {
        super();
    }

    public Cart getCart() {
        return cart;
    }

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AuctionProduct getAuctProduct() {
        return auctProduct;
    }

    public void setAuctProduct(AuctionProduct auctProduct) {
        this.auctProduct = auctProduct;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
