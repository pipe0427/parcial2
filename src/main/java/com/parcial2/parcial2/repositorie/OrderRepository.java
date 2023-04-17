package com.parcial2.parcial2.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcial2.parcial2.entity.Order1;

@Repository
public interface OrderRepository extends JpaRepository<Order1,Long> {
}
