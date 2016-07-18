package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zakaria on 13/07/2016.
 */

@Controller
public class main {

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public  String hello(ModelMap model)
    {
        model.addAttribute("Title","My Title !!");
        model.addAttribute("heading","My heading !!");
        model.addAttribute("body","My BOdy !!");
        model.addAttribute("footer","My footerx !!");


        return "hello";
    }
    @RequestMapping(value="/user",method = RequestMethod.GET )
    public String user(ModelMap model)
    {
        model.addAttribute("name","nom");
        model.addAttribute("age","age");
        model.addAttribute("address","adresse");

        return "user";

    }
}
