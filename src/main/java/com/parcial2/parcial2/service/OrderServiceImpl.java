package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcial2.parcial2.entity.Order1;
import com.parcial2.parcial2.repositorie.OrderRepository;

public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order1> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order1 saveOrder(Order1 order) {
        return orderRepository.save(order);
    }

    @Override
    public Order1 getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order1 updateOrder(Order1 order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    
}
