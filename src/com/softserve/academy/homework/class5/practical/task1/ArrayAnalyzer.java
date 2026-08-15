package com.softserve.academy.homework.class5.practical.task1;

import java.util.Scanner;

public class ArrayAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.print("Enter 5 integers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        int positiveCount = 0;
        int secondPositivePosition = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                positiveCount++;
                if (positiveCount == 2) {
                    secondPositivePosition = i + 1;
                    break;
                }
            }
        }

        if (positiveCount >= 2) {
            System.out.println("The position (ordinal number) of the second positive number is: " + secondPositivePosition);
        } else {
            System.out.println("There is no second positive number.");
        }


        int min = numbers[0];
        int minIndex = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }
        System.out.println("The minimum number is " + min + " at index " + minIndex + " (position " + (minIndex + 1) + ")");


        int productEvenNumber = 1;
        boolean hasEven = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] != 0) {
                productEvenNumber *= numbers[i];
                hasEven = true;
            }
        }

        if (hasEven) {
            System.out.println("The product of even numbers is: " + productEvenNumber);
        } else {
            System.out.println("There are no even numbers (excluding 0).");
        }
    }
}
