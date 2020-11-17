package com.example.demo.rota;

import javax.validation.Valid;

import com.example.demo.airport.AirportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rotas")
public class RotaController {


	
	private RotaRepository rotaRepository;
	private AirportRepository airportRepository;

	@InitBinder
	public void init(WebDataBinder binder){
		binder.addValidators(new NaoPodeTerRotaComOrigemEDestinoIguaisValidator(rotaRepository));
	}

	public RotaController(RotaRepository rotaRepository, AirportRepository airportRepository) {
		this.rotaRepository = rotaRepository;
		this.airportRepository =airportRepository;
	}

	@PostMapping
	public ResponseEntity<Void> cadastra(@RequestBody @Valid RotaDTO rotaDTO){
		System.out.println(rotaDTO);
		Rota rotaCriada = this.rotaRepository.save(rotaDTO.toDomain(airportRepository));
		System.out.println(rotaCriada);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
