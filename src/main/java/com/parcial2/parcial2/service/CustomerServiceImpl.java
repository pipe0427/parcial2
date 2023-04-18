package com.parcial2.parcial2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.parcial2.parcial2.entity.Customer;
import com.parcial2.parcial2.repository.CustomerRepository;



@Service
public class CustomerServiceImpl implements CustomerService  {
    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> listAllcustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerForId(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> customerWithOrders() {
        return customerRepository.customerWithOrders();
    }
    

}
