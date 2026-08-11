package com.softserve.academy.module4;

import java.util.Scanner;

public class IfStatementDemo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(("Enter two numbers to divide:"));

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (b != 0) {
            System.out.println(a + " divided by " + b + " is " + (a / b));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
        System.out.println("The program continues after the if statement.");

        double temperature = scanner.nextDouble();

        if (temperature > 30) {
            if (temperature > 35) {
                System.out.println("It's a very hot day.");
            } else {
                System.out.println("It's a hot day.");
            }
        } else if (temperature > 20) {
            System.out.println("It's a hot day.");
        } else if (temperature > 20) {
            System.out.println("It's a warm day.");
        } else if (temperature > 10) {
            System.out.println("It's a not warm day.");
        } else {
            System.out.println("It's a cold day.");
        }
        scanner.close();
    }
}
