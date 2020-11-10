package com.example.demo.airport;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AirportDTO {

    @NotBlank
    private String name;

    @NotNull
    private Long countrId;

    public Airport toModel () {

    }
}
