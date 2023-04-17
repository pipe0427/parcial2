package com.parcial2.parcial2.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false,length = 100)
    @NotEmpty
    @Size(max = 100)
    private String name;

    @Column(name = "lastName1", nullable = false,length = 100) 
    @NotEmpty
    @Size(max = 100)
    private String lastName1;

    @Column(name = "lastName2", nullable = true,length = 100) 
    private String lastName2;

    @Column(name = "city", nullable = true,length = 100)
    private String city;

    @Column(name = "category", nullable = true,length = 10)
    private int category;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Order1> orders;

    public Customer() {
    }

    public Customer(Long id, String name, String lastName1, String lastName2, String city, int category) {
        this.id = id;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.city = city;
        this.category = category;
        this.orders = new ArrayList<>();
    }

     public void addOrder(Order1 order) {
       orders.add(order);
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    
}
