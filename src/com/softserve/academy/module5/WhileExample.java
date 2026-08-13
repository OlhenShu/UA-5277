package com.softserve.academy.module5;

import java.util.Scanner;

public class WhileExample {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter a number (0 to exit):");
        int number = scanner.nextInt();
        while (number != 0) {
            System.out.println("You entered: " + number);
            System.out.println("Enter a number (0 to exit):");
            number = scanner.nextInt();
        }
        System.out.println("Exiting the program. Goodbye!");

        System.out.println("--------------------------------");

        System.out.println("Enter a number (less than or equal to 10):");

        number = scanner.nextInt();
        while (number <= 10) {
            System.out.println("Your number now is " + number);
            number++;
        }
        System.out.println("Number after the loop is " + number);
        System.out.println("Exiting the program. Goodbye!");
        System.out.println("*-*".repeat(10));

        System.out.println("Enter a number (less than or equal to 10):");
        number = scanner.nextInt();
        do {
            System.out.println("Your number now is " + number);
            number++;
        } while (number <= 10);
        System.out.println("Number after the loop is " + number);
        System.out.println("Exiting the program. Goodbye!");

    }
}
