package com.controllers;

import com.business.data.AssoTransAuctionProdDAO;
import com.business.data.AuctionProductDAO;
import com.business.data.UserDAO;
import com.business.model.AssociationTransactionAuctionProduct;
import com.business.model.AuctionProduct;
import com.business.model.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zakaria on 08/08/2016.
 */

@RestController
public class AuctProductController {

    @RequestMapping(value="/auctionproducts",method = RequestMethod.GET)
    public String viewAuctionProducts(ModelMap model)
    {
        if(AuctionProductDAO.getAll()==null)
            model.addAttribute("auctProducts","no Products available right now");
        else
            model.addAttribute("auctProducts", AuctionProductDAO.getAll());
        return "auctProducts";
    }

    @RequestMapping(value="/auctionproducts/{id}",method=RequestMethod.GET)
    public String getauctionProduct(ModelMap model,@PathVariable("id") long id)
    {
        AuctionProduct prod = AuctionProductDAO.getProduit(id);
        if(!prod.equals(null))
        {
            model.addAttribute("product", prod);
            return "auctprodInfo";
        }
        else
            return "redirect:/auctionproducts";
    }

    @RequestMapping(value="/auctionproducts/{id}/bid",method=RequestMethod.GET)
    public String Highestbid(ModelMap model,@PathVariable("id")  long prodID)
    {
        List<AssociationTransactionAuctionProduct> listasso = AssoTransAuctionProdDAO.findUsingProdId(prodID);
        AssociationTransactionAuctionProduct asso = null;
        double highestbid=0;
        User user = null;
        Iterator<AssociationTransactionAuctionProduct> it = listasso.iterator();
        while(it.hasNext())
        {
            asso=it.next();
            if(highestbid<asso.getHighestBid()) {
                highestbid = asso.getHighestBid();
                user=asso.getUser();
            }
        }
        model.addAttribute("user",user);
        model.addAttribute("highestbid",highestbid);
        return "bid";
    }

    @RequestMapping(value="/auctionproducts/{id}/bid",method=RequestMethod.POST)
    public String bid(@PathVariable("id")  long prodid,HttpServletRequest request)
    {
        if(AssoTransAuctionProdDAO.findUsingProdId(prodid).size()>0)
        {
            for (AssociationTransactionAuctionProduct a : AssoTransAuctionProdDAO.findUsingProdId(prodid))
            {
                AssociationTransactionAuctionProduct asso = a;
                     if(request.getParameter("email").equals(a.getUser().getContact().getAddress()))
                     {
                         a.setHighestBid(Double.parseDouble(request.getParameter("bid")));
                         AssoTransAuctionProdDAO.updateAsso(asso);
                         return "bidsuccess";
                     }
            }
        }

        AssociationTransactionAuctionProduct asso = new AssociationTransactionAuctionProduct();
        asso.setHighestBid(Double.parseDouble(request.getParameter("bid")));
        asso.setAuctProduct(AuctionProductDAO.getProduit(prodid));
        asso.setUser(UserDAO.getUser(request.getParameter("email")));
        String id=AssoTransAuctionProdDAO.insertAsso(asso);
        if(id!="")
             return "bidsuccess";
        else
            return "redirect:/auctionproducts/"+prodid;
    }


}

