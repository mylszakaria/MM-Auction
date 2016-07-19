package com.business.model;

import javax.persistence.*;
import java.util.Map;

/**
 * Created by zakaria on 18/07/2016.
 */
@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartId;
   @OneToOne
    private User user;


    public Cart(int cartId,User user) {
        this.cartId = cartId;
        this.user = user;
    }

    public Cart() {
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
