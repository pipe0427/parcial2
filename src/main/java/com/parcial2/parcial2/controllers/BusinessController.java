package com.parcial2.parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial2.parcial2.entity.Business;
import com.parcial2.parcial2.service.BusinessService;


@Controller
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @GetMapping({"/business"})
    public String listBusiness(Model model){
        model.addAttribute("businesses", businessService.listAllBusinesses());
        return "business";
    }

    @GetMapping({"/business/new"})
    public String showFormOfRegisterBusiness(Model model){
        Business business = new Business();
        model.addAttribute("business", business);
        return "registerBusiness";
    }

    @PostMapping({"/business"})
    public String saveBusiness(@ModelAttribute("business") Business business){
        businessService.saveBusiness(business);
        return "redirect:/business";
    }

    @GetMapping({"/business/edit/{id}"})
    public String showFormOfEditBusiness( @PathVariable Long id,Model model){
        model.addAttribute("business", businessService.getBusinessById(id));
        return  "editBusiness";
    }

    @PostMapping({"/business/{id}"})
    public String updateBusiness(@PathVariable Long id,@ModelAttribute("business") Business business,Model model){
        Business existBusiness = businessService.getBusinessById(id);
        existBusiness.setName(business.getName());
        existBusiness.setLastName1(business.getLastName1());
        existBusiness.setLastName2(business.getLastName2());
        existBusiness.setCity(business.getCity());
        existBusiness.setComision(business.getComision());

        businessService.updateBusiness(existBusiness);

        return "redirect:/business";
    }

    @GetMapping({"/business/{id}"})
    public String deleteBusiness(@PathVariable Long id){
        businessService.deleteBusiness(id);
        return "redirect:/business";
    }
}
