package com.softserve.academy.module4;

import java.util.Scanner;

public class TernaryOperator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        // Using ternary operator to find the maximum of two numbers
        int max = (a > b) ? a : b;
        System.out.println("Maximum: " + max);

        // Using ternary operator to check if a number is even or odd
        String result = (a % 2 == 0) ? "Even" : "Odd";
        System.out.println(a + " is " + result);

        boolean isEven = (a % 2 == 0);
        if (isEven) {
            System.out.println(a + " is Even");
        } else {
            System.out.println(a + " is Odd");
        }
        scanner.close();
    }
}
