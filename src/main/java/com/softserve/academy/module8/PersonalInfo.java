package com.softserve.academy.module8;

public record PersonalInfo(String name, String surname, int age, String email) {
    public PersonalInfo {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }
}
