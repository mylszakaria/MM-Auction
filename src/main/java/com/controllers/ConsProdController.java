package com.controllers;

import com.business.data.ConsultationProductDAO;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zakaria on 17/08/2016.
 */

@RestController
public class ConsProdController {

    @RequestMapping(value = "/ConsultationProducts",method = RequestMethod.GET)
    public String viewConsProducts(ModelMap model)
    {
        if(ConsultationProductDAO.getAll()==null)
            return "redirect:/index.jsp";
        else
        {
            model.addAttribute("consProducts", ConsultationProductDAO.getAll());
            return "consProducts";
        }
    }

    @RequestMapping(value = "/ConsultationsProducts/{id}",method = RequestMethod.GET)
    public String getconsProduct(ModelMap model, @PathVariable("id") long prodId)
    {
        if(ConsultationProductDAO.getProduit(prodId)==null)
            model.addAttribute("product","no product found with "+prodId+" as ID");
        else
            model.addAttribute("product",ConsultationProductDAO.getProduit(prodId));
        return "consprodInfo";
    }
}
