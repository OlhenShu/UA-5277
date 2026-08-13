package com.softserve.academy.homework.class4.practical;

import java.util.Scanner;

public class RangeChecker {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int num1, num2, num3;
        System.out.println("Please enter a 3 numbers: ");
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        num3 = sc.nextInt();

        if (num1 <= 5 && num1 >= -5 && num2 <= 5 && num2 >= -5 && num3 <= 5 && num3 >= -5) {
            System.out.println("These numbers belong to the range [-5, 5].");
        } else {
            System.out.println("Not all numbers belong to the range [-5, 5].");
        }
    }

}