package com.example.job_search.vacancyservice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CompanyRepository {
    private Map<Company, List<Vacancy>> companyVacancyMap = new HashMap<>();

    public void add(Company company, Vacancy vacancy) {
        if (vacancies(company).isEmpty()) {
            ArrayList<Vacancy> vacancies = new ArrayList<>();
            vacancies.add(vacancy);
            companyVacancyMap.put(company, vacancies);
        } else {
            List<Vacancy> currentVacancies = vacancies(company).orElseThrow();
            currentVacancies.add(vacancy);
            companyVacancyMap.put(company, currentVacancies);
        }
    }

    public Optional<List<Vacancy>> vacancies(Company company) {
        return Optional.ofNullable(companyVacancyMap.get(company));
    }

    public void deleteAll() {
        companyVacancyMap.clear();
    }
}
