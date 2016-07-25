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
    private  int id;
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
    }

    public AssociationTransactionAuctionProduct(Cart cart, AuctionProduct auctProduct, double highestBid) {

        this.cart = cart;
        this.auctProduct = auctProduct;
        this.highestBid = highestBid;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
