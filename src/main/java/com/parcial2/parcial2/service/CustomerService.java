package com.parcial2.parcial2.service;

import java.util.List;

import com.parcial2.parcial2.entity.Customer;

public interface CustomerService {

    public List<Customer> listAllcustomers();
    
    public Customer saveCustomer(Customer customer);

    public Customer getCustomerForId(Long id);

    public Customer updateCustomer(Customer customer);

    public void deleteCustomer(Long id);
}
