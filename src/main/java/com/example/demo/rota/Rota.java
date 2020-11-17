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



	public Rota(Airport origem, Airport destino, @Positive int duracao) {
		this.airportOrigem = origem;
		this.airportDestino = destino;
		this.duracao = duracao;
		this.nome = origem.getName() + " - " + destino.getName();
	}

	@Override
	public String toString() {
		return "Rota [nome=" + nome + ", airportOrigem=" + airportOrigem + ", airportDestino=" + airportDestino
				+ ", duracao=" + duracao + "]";
	}
	
	
	
}
