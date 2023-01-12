package com.example.demo.entity;

 

import java.util.Set;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

 

@Entity
@Table(name = "ROLE_DATA")
public class Role {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ROLE_NAME")
    private ERole name;

 

    public ERole getName() {
        return name;
    }

 

    public void setName(ERole name) {
        this.name = name;
    }

 

    
    public Role(ERole name) {

        this.name = name;
    }

 

    public Role() {

    }




 

    



}