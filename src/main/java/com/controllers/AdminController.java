package com.controllers;

import com.business.data.AuctionDAO;
import com.business.data.AuctionProductDAO;
import com.business.data.ConsultationProductDAO;
import com.business.model.Auction;
import com.business.model.AuctionProduct;
import com.business.model.ConsultationProduct;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zakaria on 22/08/2016.
 */

@RestController
public class AdminController  {

    @RequestMapping(value="/AddAuction.do", method = RequestMethod.GET)
    public String viewAuct(ModelMap model)
    {
        model.addAttribute("auctForm", new Auction());
        return "addAuct";
    }

    @RequestMapping(value="/AddAuction.do",method = RequestMethod.POST)
    public String processAuctAdding(@ModelAttribute("auctForm") Auction auction, ModelMap errors)
    {
        if(AuctionDAO.insertAuction(auction)==null)
        {
            errors.addAttribute("error","error while inserting auction");
            return "redirect:/AddAuction";
        }
        else
            return   "AuctionSuccess";
    }


    @RequestMapping(value="/{id}/addprodstoauct.do",method = RequestMethod.GET)
    public String viewProds(@PathVariable("id") long auctId,ModelMap model)
    {
        model.addAttribute("auctProducts", AuctionProductDAO.getAll());
        return "addprodToauct";
    }

    @RequestMapping(value="/{id}/addprodstoauct.do",method = RequestMethod.POST)
    public String addProdToAuct(@PathVariable("id") long auctId, HttpServletRequest request)
    {
        if(AuctionDAO.getAuction(auctId)==null)
            return "redirect:/"+auctId+"/addprodstoauct.do";
        else
        {
            AuctionDAO.getAuction(auctId).addProduct(AuctionProductDAO.getProduit(Double.parseDouble(request.getParameter("prod"))));
            return "addprodsuccess";
        }
    }

    @RequestMapping(value = "/{id}/products/delete.do",method = RequestMethod.POST)
    public String deleteProd(@PathVariable("id") long auctId,HttpServletRequest request)
    {
        AuctionDAO.getAuction(auctId).deleteProduct(AuctionProductDAO.getProduit(Double.parseDouble(request.getParameter("prodId"))));
        return "productdeleted";
    }

    @RequestMapping(value ="/{id}/products" ,method = RequestMethod.GET )
    public String viewAllauctProd(@PathVariable("id") long auctId,ModelMap model)
    {
        model.addAttribute("prods",AuctionDAO.getAuction(auctId).getProdList());
        return "allproducts";
    }

    @RequestMapping(value="/ConsProducts",method = RequestMethod.GET)
    public String allConsProds(ModelMap model)
    {
        model.addAttribute("ConsProducts", ConsultationProductDAO.getAll());
        return "viewConsproducts";
    }

    @RequestMapping(value="/ConsProducts/add.to",method = RequestMethod.GET)
    public String viewaddConsProds(ModelMap model)
    {
        model.addAttribute("Consprod", new ConsultationProduct());
        return "addingconsprod";
    }

    @RequestMapping(value="/ConsProducts/add.to",method = RequestMethod.POST)
    public String processAddConsProds(@ModelAttribute("Consprod")ConsultationProduct prod, ModelMap model )
    {
        if(ConsultationProductDAO.insertProduit(prod)==null)
        {
            model.addAttribute("msg","Error while inserting prod");
            return "redirect:/ConsProducts";
        }
        else
        {
            model.addAttribute("msg","Product inserted with Success");
            return "ConsProducts";
        }
    }

    @RequestMapping(value="/{id}/products/add.to",method = RequestMethod.GET)
    public String viewaddAuctProds(ModelMap model)
    {
        model.addAttribute("Auctprod", new AuctionProduct());
        return "addingauctprod";
    }

    @RequestMapping(value="/{id}/products/add.to",method = RequestMethod.POST)
    public String processAddConsProds(@ModelAttribute("Auctprod")AuctionProduct prod,@PathVariable("id") long auctId, ModelMap model )
    {
        if(AuctionProductDAO.insertProduit(prod)==null)
        {
            model.addAttribute("msg","Error while inserting prod");
            return "redirect:/ConsProducts";
        }
        else
        {
            AuctionDAO.getAuction(auctId).addProduct(prod);
            model.addAttribute("msg","Product inserted with Success");
            return "ConsProducts";
        }
    }





}



