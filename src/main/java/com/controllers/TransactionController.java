package com.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zakaria on 17/08/2016.
 */

@RestController
public class TransactionController {

    @RequestMapping(value ="/buy/{id}" , method = RequestMethod.GET)
    public String buy(@PathVariable("id") long id, HttpServletRequest request)
    {

    }
}
