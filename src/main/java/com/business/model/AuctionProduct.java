package com.business.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by zakaria on 18/07/2016.
 */
@Entity
@DiscriminatorValue(value = "Auction")
public class AuctionProduct extends Product {


    @Column
    private double productminPrice;


    public AuctionProduct() {
        super();
    }

    public double getProductminPrice() {
        return productminPrice;
    }

    public void setProductminPrice(double productminPrice) {
        this.productminPrice = productminPrice;
    }
}
