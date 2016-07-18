package com.business.model;

import java.util.Date;
import java.util.List;

/**
 * Created by zakaria on 18/07/2016.
 */
public class Auction {

    private int auctionId;
    private Date startingDate;
    private Date endingDate;
    private List<Product> prodList;

    public Auction(int auctionId, Date endingDate, Date startingDate, List<Product> prodList) {
        this.auctionId = auctionId;
        this.endingDate = endingDate;
        this.startingDate = startingDate;
        this.prodList = prodList;
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

    public List<Product> getProdList() {
        return prodList;
    }

    public void setProdList(List<Product> prodList) {
        this.prodList = prodList;
    }
}
