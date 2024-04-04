package com.example.job_search.resumeservice;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ResumeRepository {

    private Map<User, List<Resume>> userResumes = new HashMap<>();

    public void add(User user, Resume resume) {
        if (resumes(user).isEmpty()) {
            ArrayList<Resume> resumeList = new ArrayList<>();
            resumeList.add(resume);
            userResumes.put(user, resumeList);
        } else {
            List<Resume> currentResume = resumes(user).orElseThrow();
            currentResume.add(resume);
            userResumes.put(user, currentResume);
        }
    }

    public Optional<List<Resume>> resumes(User user) {
        return Optional.ofNullable(userResumes.get(user));
    }

    public void deleteAll() {
        userResumes.clear();
    }
}
