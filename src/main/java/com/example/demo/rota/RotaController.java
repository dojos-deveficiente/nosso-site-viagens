package com.example.demo.rota;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rotas")
public class RotaController {
	
	
	private RotaRepository rotaRepository;

	public RotaController(RotaRepository rotaRepository) {
		this.rotaRepository = rotaRepository;
	}

	@PostMapping
	public ResponseEntity<Void> cadastra(@RequestBody @Valid RotaDTO rotaDTO){
		System.out.println(rotaDTO);
		
		
		this.rotaRepository.save(rotaDTO.toDomain());
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
