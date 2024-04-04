package com.example.job_search;

import com.example.job_search.jobservice.JobService;
import com.example.job_search.resumeservice.ResumeRepository;
import com.example.job_search.resumeservice.User;
import com.example.job_search.vacancyservice.Company;
import com.example.job_search.vacancyservice.CompanyRepository;
import com.example.job_search.vacancyservice.Vacancy;
import com.example.job_search.vacancyservice.VacancyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("china")
@SpringBootTest
public class JobServiceTest {
    @Autowired
    private JobService jobService;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private VacancyService vacancyService;
    @MockBean
    private User user;
    @MockBean
    private Company company;
    @MockBean
    private Vacancy vacancy;

    @BeforeEach
    void init() {
        companyRepository.deleteAll();
        resumeRepository.deleteAll();
    }

    @Test
    public void testCreateCompany() {
        Company testCompany = jobService.createCompany("Test Company");
        assertEquals("Test Company", testCompany.getName());
    }

    @Test
    public void testCreateVacancy() {
        jobService.createVacancy(company, "", "", new BigDecimal(50));
        List<Vacancy> vacancies = jobService.vacancies(company);
        assertEquals(1, vacancies.size());
    }

    @Test
    public void testGetVacancyFail() {
        assertThrows(NoSuchElementException.class, () -> jobService.vacancies(company));
    }

    @Test
    public void testAddVacancyDifferentCompanies() {
        companyRepository.add(company, vacancy);
        companyRepository.add(new Company("Test company"), vacancy);
        List<Vacancy> vacancies = vacancyService.vacancies(company);
        assertEquals(1, vacancies.size());
    }

    @Test
    public void testAddVacancySameCompanies() {
        companyRepository.add(company, vacancy);
        companyRepository.add(company, vacancy);
        List<Vacancy> vacancies = vacancyService.vacancies(company);
        assertEquals(2, vacancies.size());
    }

    @Test
    public void testCreateUser() {
        User testUser = jobService.createUser("Test", "test@name.com");
        assertEquals("Test", testUser.getName());
        assertEquals("test@name.com", testUser.getEmail());
    }

    @Test
    public void testCreateResume() {
        jobService.createResume(user, new BigDecimal(50), "");
        assertEquals(1, jobService.resumes(user).size());
    }

    @Test
    public void testGetResumeFail() {
        assertThrows(NoSuchElementException.class, () -> jobService.resumes(user));
    }
}
