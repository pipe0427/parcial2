package com.parcial2.parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;
}
