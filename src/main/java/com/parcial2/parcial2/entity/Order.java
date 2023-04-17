package com.parcial2.parcial2.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount",nullable = false)
    private Double cantidad;

    @Column(name = "date",nullable = true)
    private Date date;

    @ManyToOne
    private Long id_customer;

    @ManyToOne
    private Long id_business;

}
