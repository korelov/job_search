package com.example.job_search.resumeservice;

import lombok.NonNull;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class User {
    @NonNull
    String name;
    @NonNull
    String email;
    Set<Resume> resumes = new HashSet<>();
}
