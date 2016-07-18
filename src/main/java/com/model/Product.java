package com.model;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Product {

    private int productId;
    private String productName;
    private int productInventory;
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
