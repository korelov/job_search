package com.example.job_search.resumeservice;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class Resume {
    @NonNull
    private BigDecimal desiredSalary;
    @NonNull
    private String skillsDescription;
}
