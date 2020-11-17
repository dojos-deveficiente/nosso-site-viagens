package com.example.demo.rota;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class NaoPodeTerRotaComOrigemEDestinoIguaisValidator implements Validator {
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

        }
    }
}
