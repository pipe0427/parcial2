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

}
