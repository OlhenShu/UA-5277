package com.softserve.academy.module5;

import java.util.Scanner;

public class ContinueDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number (0 to exit):");
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {
            if (number < 0) {
                System.out.println("Negative number entered. Skipping this iteration.");
                number = scanner.nextInt();
                continue;
            }
            System.out.println("You entered: " + number);
            sum += number;
            System.out.println("Enter a number (0 to exit):");
            number = scanner.nextInt();
        }
        System.out.println("Exiting the program. Goodbye!");
        System.out.println("Sum of entered numbers: " + sum);
        scanner.close();
    }
}
