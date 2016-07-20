package com.business.model;

import javax.persistence.*;
import java.util.List;

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
    @OneToMany
    private List<AssociationChartConsultationProduct> productList ;

    public Cart(int cartId,User user,List<AssociationChartConsultationProduct> productList) {
        this.cartId = cartId;
        this.user = user;
        this.productList=productList;
    }

    public Cart() {
    }

    public List<AssociationChartConsultationProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<AssociationChartConsultationProduct> productList) {
        this.productList = productList;
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

    public void addProduct(ConsultationProduct prod, int prodQtity)
    {
        if(this.productList.isEmpty())
            this.productList.add(new AssociationChartConsultationProduct(prod,prodQtity,this));
        else
        {
            AssociationChartConsultationProduct asso=null;

            while(this.productList.iterator().hasNext())
            {
                asso=this.productList.iterator().next();
                if(asso.getProduit().getProductId()==prod.getProductId())
                    asso.setProdQtity(asso.getProdQtity()+prodQtity);
            }
        }
    }
    public void deleteProduct(ConsultationProduct prod)
    {
        try {
            this.productList.remove(prod.getProductId());
        } catch (Exception e) {
            System.out.println("le produit dont l'id est " + prod.getProductId() + " n'est pas dans le panier" + e.getMessage());
        }
    }
    public double calcAmount()
    {
        double amount = 0;
        AssociationChartConsultationProduct asso = null;

        while (this.productList.iterator().hasNext()) {
            asso = this.productList.iterator().next();
            amount = asso.getProduit().getProductPrice() * asso.getProdQtity();
        }
        return amount;
    }
}
