package com.controllers;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zakaria on 08/08/2016.
 */

@RestController
public class AuctProductController {

    @RequestMapping(value="/auctionproducts",method = RequestMethod.GET)
    public String viewAuctionProducts(ModelMap model)
    {

        return "auctProducts";
    }
}
