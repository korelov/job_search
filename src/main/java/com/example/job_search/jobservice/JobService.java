package com.example.job_search.jobservice;

import com.example.job_search.vacancyservice.Company;
import com.example.job_search.vacancyservice.VacancyService;
import com.example.job_search.vacancyservice.Vacancy;
import com.example.job_search.resumeservice.Resume;
import com.example.job_search.resumeservice.ResumeService;
import com.example.job_search.resumeservice.User;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobService {
    private final VacancyService companyService;
    private final ResumeService resumeService;

    public Company createCompany(@NonNull String name) {
        return companyService.createCompany(name);
    }

    public void createVacancy(@NonNull Company company,
                              @NonNull String nameOfVacancy,
                              @NonNull String description,
                              @NonNull BigDecimal salary) {
        companyService.createVacancy(company, nameOfVacancy, description, salary);
    }

    public List<Vacancy> vacancies(@NonNull Company company) {
        return companyService.vacancies(company);
    }

    public User createUser(@NonNull String name,
                           @NonNull String email) {
        return resumeService.createUser(name, email);
    }

    public void createResume(@NonNull User user,
                             @NonNull BigDecimal desiredSalary,
                             @NonNull String skillsDescription) {
        resumeService.createResume(user, desiredSalary, skillsDescription);
    }

    public List<Resume> resumes(User user) {
        return resumeService.resumes(user);
    }
}
