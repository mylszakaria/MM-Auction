package com.model;

import java.util.Map;

/**
 * Created by zakaria on 18/07/2016.
 */
public class AuctionProduct extends Product {

    private Map<Product,Double> highestBid;
    private double productminPrice;

    public AuctionProduct(int productId, String productName, int productInventory, String productImg) {
        super(productId, productName, productInventory, productImg);
    }

    public AuctionProduct() {
    }

    public Map<Product, Double> getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(Map<Product, Double> highestBid) {
        this.highestBid = highestBid;
    }

    public double getProductminPrice() {
        return productminPrice;
    }

    public void setProductminPrice(double productminPrice) {
        this.productminPrice = productminPrice;
    }
}
