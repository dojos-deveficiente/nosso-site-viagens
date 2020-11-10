package com.example.demo.airport;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.country.Country;

public class AirportDTO {

    @NotBlank
    private String name;

    @NotNull
    private Long countryId;

    public String getName() {
        return name;
    }

    public AirportDTO(@NotBlank String name, @NotNull Long countryId) {
        this.name = name;
        this.countryId = countryId;
    }

    public Airport toModel (EntityManager em) {
    	Country country = em.find(Country.class, this.countryId);
    	return new Airport(name, country);
    }
}
