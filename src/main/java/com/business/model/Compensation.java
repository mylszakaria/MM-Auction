package com.business.model;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Compensation {

    private int compId;
    private double minPrice;

    public Compensation(double minPrice, int compId) {
        this.minPrice = minPrice;
        this.compId = compId;
    }

    public int getCompId() {
        return compId;
    }

    public void setCompId(int compId) {
        this.compId = compId;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
