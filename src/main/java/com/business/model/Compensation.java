package com.business.model;

import javax.persistence.*;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
public class Compensation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long compId;
    @Column
    private double minPrice;




    public Compensation() {
        super();
    }

    public long getCompId() {
        return compId;
    }

    public void setCompId(long compId) {
        this.compId = compId;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }
}
