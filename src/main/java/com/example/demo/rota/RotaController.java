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

	@PostMapping
	public ResponseEntity<Void> cadastra(@RequestBody @Valid RotaDTO rotaDTO){
		System.out.println(rotaDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
