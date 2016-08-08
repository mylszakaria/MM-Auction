package com.business.model;

import javax.persistence.*;

/**
 * Created by zakaria on 19/07/2016.
 */
@Entity
@DiscriminatorValue(value = "Consultation")
public class ConsultationProduct extends Product {

    @Column
    private double productPrice;

    public ConsultationProduct() {
        super();
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }


}
