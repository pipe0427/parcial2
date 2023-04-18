package com.parcial2.parcial2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    @Query(
        value = "select * from customer c left join order1 o on c.id = o.customer_id order by c.last_name1,c.last_name2,c.name asc",
    nativeQuery=true)
    public  List<Customer> customerWithOrders();

}
