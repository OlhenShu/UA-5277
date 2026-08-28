package com.softserve.academy.homework.Topic5.Task1;

import java.util.Scanner;

public class FiveNumbers {
    static Scanner sc = new Scanner(System.in);
    int numbers[] = new int[5];


    public static void main(String[] args) {
        FiveNumbers fn = new FiveNumbers();
        System.out.println("Enter 5 integers: ");
        for (int i = 0; i < 5; i++) {
            fn.numbers[i] = sc.nextInt();
        }

        int coun = 0;
        int secondPosisiveIndex = -1;
        for (int i = 0; i < 5; i++) {
            if (fn.numbers[i] > 0) {
                coun++;
                if (coun == 2) {
                    secondPosisiveIndex = i;
                    break;
                }
            }
        }
        if (secondPosisiveIndex == -1) {
            System.out.println("There is no second positive number.");
        } else {
            System.out.println("The second positive number is: " + fn.numbers[secondPosisiveIndex]);
        }

        int min = fn.numbers[0];
        int minIndex = 0;
        for (int i = 1; i < 5; i++) {
            if (fn.numbers[i] < min) {
                min = fn.numbers[i];
                minIndex = i;
            }
        }
        System.out.println("The minimum number is: " + min);
        System.out.println("The index of the minimum number is: " + minIndex);

        int product = 1;
        boolean hasEven = false;
        for (int i = 0; i < 5; i++) {
            product *= fn.numbers[i];
            if (fn.numbers[i] % 2 == 0) {
                hasEven = true;
            }
        }
        System.out.println("The product of all numbers is: " + product);
        if (hasEven) {
            System.out.println("There is at least one even number.");
        } else {
            System.out.println("There are no even numbers.");
        }
    }
}
