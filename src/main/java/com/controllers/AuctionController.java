package com.controllers;

import com.business.data.AuctionDAO;
import com.business.model.Auction;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zakaria on 17/08/2016.
 */

@RestController
public class AuctionController {

    @RequestMapping(value = "/showAuctions.do",method = RequestMethod.GET)
    public String showAuctions(ModelMap model)
    {
        model.addAttribute("Auctions", AuctionDAO.getAll());
        return "auctions";
    }

    @RequestMapping(value="/auctions/{id}",method = RequestMethod.GET)
    public String showAuctionDet(ModelMap model, @PathVariable("id") long auctId)
    {
        Auction auct = AuctionDAO.getAuction(auctId);
        if(auct==null)
            model.addAttribute("error","no auction with"+auctId+" as an ID");
        else
            model.addAttribute("auction",auct);
        return "auctionDet";
    }

}
