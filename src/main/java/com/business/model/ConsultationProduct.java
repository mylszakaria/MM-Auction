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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public ConsultationProduct(int productId, String productName, int productInventory, String productImg, double productPrice) {
        super(productId, productName, productInventory, productImg);
        this.productPrice=productPrice;

    }

    public ConsultationProduct() {
    }
}
