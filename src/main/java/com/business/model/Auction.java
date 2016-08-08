package com.business.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long auctionId;
    @Column
    private Date startingDate;
    @Column
    private Date endingDate;
    @OneToMany
    private List<AuctionProduct> prodList;
    @ManyToOne
    private Compensation comp;
    @ManyToMany
    private List<User> users;

    public Auction() {
        super();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Compensation getComp() {
        return comp;
    }

    public void setComp(Compensation comp) {
        this.comp = comp;
    }


    public long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(long auctionId) {
        this.auctionId = auctionId;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public List<AuctionProduct> getProdList() {
        return prodList;
    }

    public void setProdList(List<AuctionProduct> prodList) {
        this.prodList = prodList;
    }

    public void addProduct(AuctionProduct prod)
    {

            AuctionProduct auctPro=null;
            while(this.prodList.iterator().hasNext())
            {
                auctPro=this.prodList.iterator().next();
                if(auctPro.getProductId()== prod.getProductId())
                    System.out.println("Product already exists");
            }
            this.prodList.add(prod);
    }

    public void deleteProduct(AuctionProduct prod)
    {

        AuctionProduct auctPro=null;
        while(this.prodList.iterator().hasNext())
        {
            auctPro=this.prodList.iterator().next();
            if(auctPro.getProductId()== prod.getProductId())
            {
                this.prodList.remove(prod);
                System.out.println("Product deleted");
            }
        }
    }

}
