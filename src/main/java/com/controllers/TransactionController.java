package com.controllers;

import com.business.data.*;
import com.business.model.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

/**
 * Created by zakaria on 17/08/2016.
 */

@RestController
public class TransactionController {

    @RequestMapping(value ="/users/{id}/cart/buy" , method = RequestMethod.POST)
    public String buy(@PathVariable("id") long userId)
    {
        Transaction trans = new Transaction();
        trans.setUser(UserDAO.getUser(userId));
        trans.setTransAmount(trans.getUser().getCart().calcAmount());
        trans.getUser().addTransaction(trans);
        if(TransactionDAO.insertTransaction(trans)==null)
            return "redirect:/users/"+userId+"/cart/";
        else
            return "TransactionSuccess";
    }

    @RequestMapping(value ="/auctions/{id}/time_ended" ,method = RequestMethod.POST)
    public String auctionWinner(@PathVariable("id") long auctId, ModelMap model)
    {
        List<AssociationTransactionAuctionProduct> assos= AuctionDAO.getAuction(auctId).getAssos();
        List<AuctionProduct> prods = AuctionDAO.getAuction(auctId).getProdList();
        User userwinner = null;
        double highest = 0;
        List<AuctionWinner> auctwinners=null;
        if(prods==null)
            return "redirect:/auctions/"+auctId;
        else
        {
            for(AuctionProduct p : prods)
            {
                AuctionProduct prod =p;
                for(AssociationTransactionAuctionProduct a : assos)
                {
                    AssociationTransactionAuctionProduct asso = a;
                    if(a.getAuctProduct()==p)
                    {
                        if(asso.getHighestBid()>highest && userwinner!=asso.getUser())
                        {
                            highest = asso.getHighestBid();
                            userwinner = asso.getUser();
                        }
                    }
                }
                AuctionWinner winner = new AuctionWinner();
                winner.setUser(userwinner);
                winner.setBid(highest);
                winner.setProd(prod);
                AuctionWinnerDAO.insertAuctionWinner(winner);
                auctwinners.add(winner);
            }
        }
        model.addAttribute("winners",auctwinners);
        model.addAttribute("auct",auctId);
        return "auctionwinners";
    }
}
