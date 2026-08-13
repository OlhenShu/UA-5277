package com.softserve.academy.homework.class4.practical;

import java.util.Scanner;

public class MinMaxFinder {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int num1, num2, num3;
        int min, max;
        System.out.println("Please enter a 3 numbers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();

        min = Math.min(num1, Math.min(num2, num3));
        max = Math.max(num1, Math.max(num2, num3));
        System.out.println("The minimum number is: " + min + " and maximum number is: " + max);

    }
}
