package com.example.demo.repository;

import org.springframework.stereotype.Repository;

@Repository
public class TestRepository {
    public String getFullName(String firstName, String lastName) {
        return firstName + lastName;
    }
}
