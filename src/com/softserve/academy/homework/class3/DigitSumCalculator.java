package com.softserve.academy.homework.class3;

public class DigitSumCalculator {
    public static int calculateDigitSum(int number) {
        int sum = 0;
        if (number >= 100 && number <= 999) {
            sum = number % 10;
            number = number / 10;
            sum = sum + number % 10;
            number = number / 10;
            sum = sum + number % 10;
        } else {
            // Handle the error if the number is not three digits
            throw new IllegalArgumentException("The input number is not a three-digit number.");
        }
        return sum;
    }
}
