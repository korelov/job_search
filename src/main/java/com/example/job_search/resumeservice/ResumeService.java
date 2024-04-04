package com.example.job_search.resumeservice;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;

    public User createUser(@NonNull String name, @NonNull String email) {
        return new User(name, email);
    }

    public void createResume(User user, BigDecimal desiredSalary, String skillsDescription) {
        Resume resume = new Resume(desiredSalary, skillsDescription);
        user.getResumes().add(resume);
        resumeRepository.add(user, resume);
    }

    public List<Resume> resumes(User user) {
        return resumeRepository.resumes(user).orElseThrow();
    }
}
