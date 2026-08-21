package com.softserve.academy.homework.Topic4;

import java.util.Scanner;

public class NumbersValue {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter three numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int min = Math.min(Math.min(a, b), c);
        System.out.println("The minimum value is: " + min);

        int max = Math.max(Math.max(a, b), c);
        System.out.print("The maximum value is: " + max);

    }
}
