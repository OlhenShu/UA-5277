package com.softserve.academy.homework.Topic5.Task1;

import java.util.Scanner;

public class TenNumbers {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = new int[10];
        System.out.println("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            numbers[i] = sc.nextInt();
        }

        boolean firstFivePositive = true;
        for (int i = 0; i < 5; i++) {
            if (numbers[i] <= 0) {
                firstFivePositive = false;
                break;
            }

        }
        if (firstFivePositive == true) {
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += numbers[i];
            }
            System.out.println("Sum of first five positive numbers: " + sum);
        } else {
            int product = 1;
            for (int i = 5; i < 10; i++) {
                product *= numbers[i];
            }
            System.out.println("Product of the last five numbers: " + product);
        }
    }
}
