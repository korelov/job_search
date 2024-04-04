package com.example.job_search.vacancyservice;

import lombok.NonNull;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class Company {
    @NonNull
    String name;
    Set<Vacancy> vacancies = new HashSet<>();
}
