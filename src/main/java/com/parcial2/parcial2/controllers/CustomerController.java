package com.parcial2.parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial2.parcial2.entity.Customer;
import com.parcial2.parcial2.repository.CustomerRepository;
import com.parcial2.parcial2.service.CustomerService;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;


    @GetMapping({"/customer","/"})
    public String listCustomer(Model model){
        model.addAttribute("customers", customerService.listAllcustomers());
        return "customer";
    }

    

    @GetMapping({"/customer/new"})
    public String showFormOfRegisterCustomer (Model model){
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "registerCustomer";
    }

    @PostMapping("customer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.saveCustomer(customer);
        return "redirect:/customer";
    }


    @GetMapping({"/customer/edit/{id}"})
    public String showFormOfEditCustomer (@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.getCustomerForId(id));
        return "editCustomer";
    }

    @PostMapping("/customer/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer,Model model){
        Customer existingCustomer = customerService.getCustomerForId(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setLastName1(customer.getLastName1());
        existingCustomer.setLastName2(customer.getLastName2());
        existingCustomer.setCity(customer.getCity());
        existingCustomer.setCategory(customer.getCategory());

        customerService.updateCustomer(existingCustomer);
        return "redirect:/customer";
    }
    @GetMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        if(customerService.getCustomerForId(id).getOrders().size() == 0){
            customerService.deleteCustomer(id);
            return "redirect:/customer";
        }
        return "redirect:/customer";
        
    }

}
