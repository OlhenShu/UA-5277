package com.softserve.academy.homework.maksym.L2;

public class DigitSumCalculator {
    public static int calculateDigitSum(int number) {
        if (number >= 100 && number <= 999) {
            return (number / 100) + ((number / 10) % 10) + (number % 10);
        } else {
            // Handle the error if the number is not three digits
            throw new IllegalArgumentException("The input number is not a three-digit number.");
        }
    }
}