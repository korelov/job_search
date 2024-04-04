package com.example.job_search.vacancyservice;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Vacancy {
    @NonNull
    private String nameOfVacancy;
    @NonNull
    private String description;
    @NonNull
    private BigDecimal salary;
    @NonNull
    private String currency;
}
