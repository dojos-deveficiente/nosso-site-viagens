package com.example.demo.rota;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.util.StringUtils;

import com.example.demo.airport.Airport;
import com.example.demo.airport.AirportRepository;

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


    public Rota toDomain(AirportRepository airportRepository) {
        final Airport aeroportoOrigem = airportRepository.findById(aeroportoOrigemId)
                .orElseThrow(IllegalArgumentException::new);
        final Airport aeroportoDestino = airportRepository.findById(aeroportoDestinoId)
                .orElseThrow(IllegalArgumentException::new);
        Rota rota = new Rota(aeroportoOrigem, aeroportoDestino, this.duracao);
        if(StringUtils.hasText(this.nome)) {
        	rota.setNome(this.nome);
        }
        return rota;
    }

}
