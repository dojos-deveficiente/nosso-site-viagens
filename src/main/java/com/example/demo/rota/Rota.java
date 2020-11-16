package com.example.demo.rota;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Positive;

import com.example.demo.airport.Airport;

@Entity
public class Rota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Airport airport;
	private Airport airport2;
	private @Positive int duracao;

	public Rota(String nome, Airport airport, Airport airport2, @Positive int duracao) {
		this.nome = nome;
		this.airport = airport;
		this.airport2 = airport2;
		this.duracao = duracao;
	}

	
	
}
