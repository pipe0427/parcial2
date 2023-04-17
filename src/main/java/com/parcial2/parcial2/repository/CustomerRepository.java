package com.parcial2.parcial2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    // @Query("select c.last_name1,c.last_name2,o from Customer c left join fetch order1 o on c.id = o.customer_id order by c.name asc")
    // public  Customer customerWithOrders();

}
