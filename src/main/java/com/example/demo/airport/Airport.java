package com.example.demo.airport;

import com.example.demo.country.Country;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @ManyToOne
    private Country country;

    @Deprecated
    public Airport () {

    }

    public Airport(@NotBlank String name, Country country) {
		this.name = name;
		this.country = country;
	}

	public String getName() {
		return this.name;
	}

}
