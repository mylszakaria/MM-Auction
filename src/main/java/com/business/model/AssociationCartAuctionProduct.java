package com.business.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zakaria on 19/07/2016.
 */
@Entity
public class AssociationCartAuctionProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private AuctionProduct auctProduct;
    @Column
    private double highestBid;

    public AssociationCartAuctionProduct() {
    }

    public AssociationCartAuctionProduct(Cart cart, AuctionProduct auctProduct, double highestBid) {

        this.cart = cart;
        this.auctProduct = auctProduct;
        this.highestBid = highestBid;
    }

    public Cart getCart() {
        return cart;
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
