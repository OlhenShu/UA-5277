package com.softserve.academy.homework.Topic2;

import java.util.Scanner;

public class SmallestNumber {

    static Scanner sc = new Scanner(System.in);
    static void main() {

        int num1;
        int num2;
        int num3;

        System.out.println("Input the first number: ");
        num1 = sc.nextInt();

        System.out.println("Input the second number: ");
        num2 = sc.nextInt();

        System.out.println("Input the third number: ");
        num3 = sc.nextInt();

        int smallest = Math.min(num1, Math.min(num2, num3));
        System.out.println("The smallest number is: " + smallest);

        sc.close();
    }
}
