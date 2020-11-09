package com.example.demo.company;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UniqueNameValidator implements Validator {

    private CompanyRepository companyRepository;

    public UniqueNameValidator(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return CompanyDTO.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        boolean exists = companyRepository.existsByName(((CompanyDTO)o).getNome());
        if (exists) {
            errors.rejectValue(((CompanyDTO)o).getNome(), null, "Nome da companhia já existe");
        }
    }
}
