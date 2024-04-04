package com.example.job_search.vacancyservice;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VacancyService {
    private final CompanyRepository companyRepository;
    @Value("${currency.name}")
    private String currency;

    public Company createCompany(@NonNull String name) {
        return new Company(name);
    }

    public void createVacancy(Company company, String nameOfVacancy, String description, BigDecimal salary) {
        Vacancy vacancy = new Vacancy(nameOfVacancy, description, salary, currency);
        company.getVacancies().add(vacancy);
        companyRepository.add(company, vacancy);
    }

    public List<Vacancy> vacancies(Company company) {
        return companyRepository.vacancies(company).orElseThrow();
    }
}
