package com.parcial2.parcial2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.parcial2.parcial2.entity.Business;
import com.parcial2.parcial2.entity.Customer;
import com.parcial2.parcial2.entity.Order1;
import com.parcial2.parcial2.service.BusinessService;
import com.parcial2.parcial2.service.CustomerService;
import com.parcial2.parcial2.service.OrderService;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private BusinessService businessService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/order")
    public String listOrder(Model model){
        model.addAttribute("orders", orderService.listAllOrders());
        return "order";
    }

    @GetMapping("/order/new")
    public String showFormRegisterOrder(Model model){
        Order1 order = new Order1();
        model.addAttribute("order", order);
        model.addAttribute("customers", customerService.listAllcustomers());
        model.addAttribute("businesses",businessService.listAllBusinesses());

        return "registerOrder";
    }

    @PostMapping("/order")
    public String saveOrder(@ModelAttribute("order") Order1 order){
        return "redirect:/order";
    }

    @GetMapping("/order/edit/{id}")
    public String showFormEditOrder(@PathVariable Long id,Model model,@ModelAttribute("businesses") Business business,@ModelAttribute("customers") Customer customer){
        model.addAttribute("order", orderService.getOrderById(id));
        model.addAttribute("customers", customerService.listAllcustomers());
        model.addAttribute("businesses", businessService.listAllBusinesses());

        return "editOrder";
    }

    @PostMapping("/order/{id}")
    public String updateOrder(@PathVariable Long id,@ModelAttribute("order") Order1 order){
        Order1 existOrder =  orderService.getOrderById(id);
        existOrder.setAmount(order.getAmount());
        existOrder.setDate(order.getDate());
        existOrder.setCustomer(order.getCustomer());
        existOrder.setBusiness(order.getBusiness());

        return "redirect:/order";
    }

    @GetMapping("/order/{id}")
    public String deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return "redirect:/order";
    }
}
