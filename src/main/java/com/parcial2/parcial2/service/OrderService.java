package com.parcial2.parcial2.service;

import java.util.List;

import com.parcial2.parcial2.entity.Order1;

public interface OrderService {
    
    public List<Order1> listAllOrders();

    public Order1 saveOrder(Order1 order);
    
    public Order1 getOrderById(Long id);

    public Order1 updateOrder(Order1 order);

    public void deleteOrder(Long id);
}
