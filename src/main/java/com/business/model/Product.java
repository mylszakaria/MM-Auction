package com.business.model;

import javax.persistence.*;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ProductType")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @Column
    private String productName;
    @Column
    private int productInventory;
    @Column
    private String productImg;

    public Product(int productId, String productName, int productInventory, String productImg) {
        this.productId = productId;
        this.productName = productName;
        this.productInventory = productInventory;
        this.productImg = productImg;
    }

    public Product() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }
}
