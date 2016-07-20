package com.business.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zakaria on 19/07/2016.
 */
@Entity
public class AssociationChartConsultationProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private ConsultationProduct produit;
    @ManyToOne
    private Cart cart;
    @Column
    private int prodQtity;

    public AssociationChartConsultationProduct(ConsultationProduct produit, int prodQtity, Cart cart) {
        this.produit = produit;
        this.prodQtity = prodQtity;
        this.cart = cart;
    }

    public AssociationChartConsultationProduct() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ConsultationProduct getProduit() {
        return produit;
    }

    public void setProduit(ConsultationProduct produit) {
        this.produit = produit;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getProdQtity() {
        return prodQtity;
    }

    public void setProdQtity(int prodQtity) {
        this.prodQtity = prodQtity;
    }
}
