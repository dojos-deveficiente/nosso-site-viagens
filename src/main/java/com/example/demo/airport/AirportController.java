package com.example.demo.airport;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/airports")
public class AirportController {

    private AirportRepository airportRepository;
	private EntityManager em;
	private final AirportUniqueNameValidator airportUniqueNameValidator;

	@InitBinder
	public void init(WebDataBinder webDataBinder) {
	    webDataBinder.addValidators(airportUniqueNameValidator);
    }

    public AirportController(AirportRepository airportRepository, EntityManager em, AirportUniqueNameValidator airportUniqueNameValidator) {
		this.airportRepository = airportRepository;
		this.em = em;
        this.airportUniqueNameValidator = airportUniqueNameValidator;
    }

    @PostMapping
    public ResponseEntity<Void> add (@Valid @RequestBody AirportDTO airportDTO) {
        airportRepository.save(airportDTO.toModel(em));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
