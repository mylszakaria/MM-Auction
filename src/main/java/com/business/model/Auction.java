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
    private int auctionId;
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


    public Auction(int auctionId, Date endingDate, Date startingDate, List<AuctionProduct> prodList,Compensation comp, List<User> users) {
        this.auctionId = auctionId;
        this.endingDate = endingDate;
        this.startingDate = startingDate;
        this.prodList = prodList;
        this.comp=comp;
        this.users=users;
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

    public Auction() {
    }

    public int getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(int auctionId) {
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
}
