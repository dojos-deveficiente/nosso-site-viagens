package com.example.demo.airport;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportRepository airportRepository;
	private EntityManager em;

    public AirportController(AirportRepository airportRepository, EntityManager em) {
		this.airportRepository = airportRepository;
		this.em = em;
	}

    @PostMapping
    public ResponseEntity<Void> add (@Valid @RequestBody AirportDTO airportDTO) {
        airportRepository.save(airportDTO.toModel(em));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
