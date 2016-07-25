package com.business.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zakaria on 19/07/2016.
 */
@Entity
public class AssociationTransactionConsultationProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private ConsultationProduct produit;
    @ManyToOne
    private Transaction trans;
    @Column
    private int prodQtity=0;
    @Transient
    private Cart cart;

    public AssociationTransactionConsultationProduct(ConsultationProduct produit, int prodQtity, Transaction trans, Cart cart) {
        this.produit = produit;
        this.prodQtity = prodQtity;
        this.trans = trans;
        this.cart=cart;
    }

    public AssociationTransactionConsultationProduct() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
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

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction Trans) {
        this.trans = trans;
    }

    public int getProdQtity() {
        return prodQtity;
    }

    public void setProdQtity(int prodQtity) {
        this.prodQtity = prodQtity;
    }
}
