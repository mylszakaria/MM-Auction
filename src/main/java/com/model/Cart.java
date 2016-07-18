package com.model;

import java.util.Map;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Cart {

    private int userId;
    private Map<Product ,Integer> addedPro;//products added to the cart

    public Cart(int userId, Map<Product, Integer> addedPro) {
        this.userId = userId;
        this.addedPro = addedPro;
    }

    public Cart() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Map<Product, Integer> getAddedPro() {
        return addedPro;
    }

    public void setAddedPro(Map<Product, Integer> addedPro) {
        this.addedPro = addedPro;
    }
}
