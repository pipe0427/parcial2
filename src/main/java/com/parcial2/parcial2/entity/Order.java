package com.parcial2.parcial2.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order")
public class Order {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount",nullable = false)
    private Double amount;

    @NotNull
    @Column(name = "date",nullable = true)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

     @ManyToOne(fetch = FetchType.LAZY)
     private Customer customer;

     @ManyToOne(fetch = FetchType.LAZY)
     private Business business;

    public Order() {
    }

    public Order(Long id, Double amount, Date date, Customer customer, Business business) {
        this.id = id;
        this.amount = amount;
        this.date = date;
         this.customer = customer;
         this.business = business;
    }

    @PrePersist
    public void prePersist(){
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

     public Customer getCustomer() {
         return customer;
     }

     public void setCustomer(Customer customer) {
         this.customer = customer;
     }

     public Business getBusiness() {
         return business;
     }

     public void setBusiness(Business business) {
         this.business = business;
     }
    

    
}
