package com.business.model;

import javax.persistence.Transient;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Cart {

    private Transaction trans;

    private int cartId;

    private User user;

    private List<AssociationTransactionConsultationProduct> productList ;

    public Cart(int cartId,User user,List<AssociationTransactionConsultationProduct> productList,Transaction trans) {
        this.cartId = cartId;
        this.user = user;
        this.productList=productList;
        this.trans=trans;
    }

    public Cart() {
    }

    public Transaction getTrans() {
        return trans;
    }

    public void setTrans(Transaction trans) {
        this.trans = trans;
    }

    public List<AssociationTransactionConsultationProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<AssociationTransactionConsultationProduct> productList) {
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
            this.productList.add(new AssociationTransactionConsultationProduct(prod,prodQtity,trans,this));
        else
        {
            AssociationTransactionConsultationProduct asso=null;

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
        AssociationTransactionConsultationProduct asso = null;

        while (this.productList.iterator().hasNext()) {
            asso = this.productList.iterator().next();
            amount = asso.getProduit().getProductPrice() * asso.getProdQtity();
        }
        return amount;
    }
}
