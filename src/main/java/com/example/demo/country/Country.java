package com.example.demo.country;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Country {

    @Deprecated
    public Country() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private LocalDate createdAt = LocalDate.now();

    public Country(String nome) {
        this.name = nome;
    }
}
