package com.parcial2.parcial2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "business")
public class Business {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false,length = 100)
    private String name;


    @Column(name = "lastName", nullable = false,length = 100)
    private String lastName1;


    @Column(name = "lastName2", nullable = true,length = 100)
    private String lastName2;

    @Column(name = "city", nullable = true,length = 100)
    private String city;

    @Column(name = "comision", nullable = true)
    private Float comision;

    @OneToMany
    private Long id_comercial;

    public Business() {
    }

    public Business(Long id, String name, String lastName1, String lastName2, String city, Float comision,
            Long id_comercial) {
        this.id = id;
        this.name = name;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.city = city;
        this.comision = comision;
        this.id_comercial = id_comercial;
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

    public Float getComision() {
        return comision;
    }

    public void setComision(Float comision) {
        this.comision = comision;
    }

    public Long getId_comercial() {
        return id_comercial;
    }

    public void setId_comercial(Long id_comercial) {
        this.id_comercial = id_comercial;
    }

    
}
