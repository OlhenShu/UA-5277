package com.softserve.academy.homework.Topic3;

import java.util.Scanner;

public class ThreeNumbers {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter three numbers from -5 to 5: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        if (a < -5 || a > 5 || b < -5 || b > 5 || c < -5 || c > 5) {
            System.out.println("Error: Numbers must be in the range from -5 to 5.");
        } else {
            System.out.println("All numbers are within the range.");

        }
    }
}