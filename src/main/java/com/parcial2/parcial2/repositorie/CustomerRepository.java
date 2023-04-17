package com.parcial2.parcial2.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}