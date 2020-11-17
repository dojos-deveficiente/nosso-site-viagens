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
        
        rotaRepository.existsAirportOrigemIdAndAirportDestinoId(rotaDTO.getOrigemId(), rotaDTO.get)
    }
}
