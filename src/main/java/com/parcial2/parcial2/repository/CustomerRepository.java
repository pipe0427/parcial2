package com.parcial2.parcial2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
    @Query(

        value = "select * from customer cu left join order ord on cu.id = ord.customer_id order by cu.last_name1,cu.last_name2,cu.name asc",

    nativeQuery=true)
    public  List<Customer> customerWithOrders();

}
