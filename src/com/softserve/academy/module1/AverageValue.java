package com.softserve.academy.module1;

import java.util.Scanner;

public class AverageValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        double firstNumber = scanner.nextDouble();
        System.out.println("Enter the second number:");
        double secondNumber = scanner.nextDouble();
        System.out.println("Enter the third number:");
        double thirdNumber = scanner.nextDouble();
        System.out.println("You entered the following numbers:");
        System.out.println("Third number: " + thirdNumber);
        System.out.println("Second number: " + secondNumber);
        System.out.println("First number: " + firstNumber);

        double average = (firstNumber + secondNumber + thirdNumber) / 3;
        System.out.println("The average value is: " + average);

        scanner.close();
    }
}
