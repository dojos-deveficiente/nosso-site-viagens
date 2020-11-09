package com.example.demo.company;

import com.example.demo.country.CountryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyRepository companyRepository;
    private final CountryRepository countryRepository;

    private final UniqueNameValidator validator;

    public CompanyController(CompanyRepository companyRepository,
                             CountryRepository countryRepository,
                             UniqueNameValidator validator) {

        this.companyRepository = companyRepository;
        this.countryRepository = countryRepository;
        this.validator = validator;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validator);
    }

    @PostMapping
    public ResponseEntity<Void> creatCompany(@Valid @RequestBody CompanyDTO companyDTO) {
        companyRepository.save(companyDTO.toModel(countryRepository));

        return ResponseEntity.created(URI.create("OK")).build();
    }
}
