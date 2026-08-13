package com.softserve.academy.module5;

import java.util.Scanner;

/**
 * The BreakDemo class demonstrates the use of the break statement in a while loop.
 * It prompts the user to enter numbers and exits the loop when a negative number or zero
 * is entered.
 */
public class BreakDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number (0 to exit):");
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {
            if (number <= 0) {
                System.out.println("Negative number entered or zero. Exiting the loop.");
                break;
            }
            System.out.println("You entered: " + number);
            System.out.println("Enter a number (0 to exit):");
            number = scanner.nextInt();
            sum += number;
        }
        System.out.println("Exiting the program. Goodbye!");
        System.out.println("Sum of entered numbers: " + sum);
        scanner.close();
    }
}
