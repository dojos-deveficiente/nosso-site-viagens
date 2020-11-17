package com.example.demo.rota;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NaoPodeTerRotaComOrigemEDestinoIguaisValidator implements Validator {
    private final RotaRepository rotaRepository;

    public NaoPodeTerRotaComOrigemEDestinoIguaisValidator(RotaRepository rotaRepository) {
        this.rotaRepository = rotaRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        RotaDTO rotaDTO = (RotaDTO) target;
        if(rotaDTO.temOrigemEDestinoIgual()){
            errors.reject(null,"aeroporto de destino e origem precisam ser diferentes" );
        }
        
        boolean existe = rotaRepository.existsByAirportOrigem_Id_AndAirportDestino_Id(rotaDTO.getOrigemId(), rotaDTO.getDestinoId());
        
        if (existe) {
        	errors.reject(null, "Já existe uma rota com a mesma origem e destino");
        }
    }
}
