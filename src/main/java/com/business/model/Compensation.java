package com.business.model;

import javax.persistence.*;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int compId;
    @Column
    private double minPrice;

    public Compensation(double minPrice, int compId) {
        this.minPrice = minPrice;
        this.compId = compId;
    }

    public Compensation() {
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
