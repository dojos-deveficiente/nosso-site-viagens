package com.example.demo.rota;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RotaDTO {

	private String nome;
	
	@Positive
	private int duracao;
	
	@NotNull
	private Long aeroportoOrigemId;
	
	@NotNull
	private Long aeroportoDestinoId;

	public RotaDTO(String nome, @Positive int duracao, @NotNull Long aeroportoOrigemId,
			@NotNull Long aeroportoDestinoId) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.aeroportoOrigemId = aeroportoOrigemId;
		this.aeroportoDestinoId = aeroportoDestinoId;
	}


	@Override
	public String toString() {
		return "RotaDTO [nome=" + nome + ", duracao=" + duracao + ", aeroportoOrigemId=" + aeroportoOrigemId
				+ ", aeroportoDestinoId=" + aeroportoDestinoId + "]";
	}

}
