package com.example.demo.airport;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportRepository airportRepository;

    public AirportController(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @PostMapping
    public ResponseEntity<Void> add (AirportDTO airportDTO) {
        airportRepository.save(airportDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
