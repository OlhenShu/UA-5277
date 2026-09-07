package com.softserve.academy.module9;

public class OwnExceptionExample {

    static void checkAge(int age) {
        if (age < 18) {
            throw new CastomException("Age must be at least 18");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(15);
        } catch (CastomException e) {
            System.err.println("Caught exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
