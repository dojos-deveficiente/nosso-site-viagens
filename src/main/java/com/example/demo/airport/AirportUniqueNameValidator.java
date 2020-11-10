package com.example.demo.airport;

import com.example.demo.company.CompanyDTO;
import com.example.demo.company.CompanyRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AirportUniqueNameValidator implements Validator {

    private AirportRepository airportRepository;

    public AirportUniqueNameValidator(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AirportDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        boolean exists = airportRepository.existsByName(((AirportDTO)o).getName());
        if (exists) {
            errors.rejectValue("name", null, "Nome do aeroporto já existe");
        }
    }
}
