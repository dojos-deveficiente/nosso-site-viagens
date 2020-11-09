package com.example.demo.company;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

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
        boolean exists = companyRepository.existsByName(((CompanyDTO)o).getNome());
        if (exists) {
            throw new RuntimeException("Nome da companhia já existe");
        }
    }
}
