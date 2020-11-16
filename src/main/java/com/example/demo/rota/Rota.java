package com.example.demo.rota;

import com.example.demo.airport.Airport;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Positive;

@Entity
public class Rota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;

	@ManyToOne
	private Airport airportOrigem;

	@ManyToOne
	private Airport airportDestino;
	private @Positive int duracao;

	public Rota(String nome, Airport airport, Airport airport2, @Positive int duracao) {
		this.nome = nome;
		this.airportOrigem = airport;
		this.airportDestino = airport2;
		this.duracao = duracao;
	}

	
	
}
