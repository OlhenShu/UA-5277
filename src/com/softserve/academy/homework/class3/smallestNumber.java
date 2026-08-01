package com.softserve.academy.homework.class3;

import java.util.Scanner;

public class smallestNumber {
    public static void main(String[] args) {
        int num1, num2, num3;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first number: ");
        num1 = scanner.nextInt();
        System.out.print("Input second number: ");
        num2 = scanner.nextInt();
        System.out.print("Input third number: ");
        num3 = scanner.nextInt();
        if (num1 <= num2 && num1 <= num3) {
            System.out.println("The smallest number is: " + num1);
        }
        else if (num2 <= num1 && num2 <= num3) {
            System.out.println("The smallest number is: " + num2);
        }
        else {
            System.out.println("The smallest number is: " + num3);
        }
    }
}
