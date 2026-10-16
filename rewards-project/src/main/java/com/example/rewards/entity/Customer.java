package com.example.rewards.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
public class Customer {

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;


    public Customer(Long id,String name) {
        this.id = id;
        this.name = name;
    }
}