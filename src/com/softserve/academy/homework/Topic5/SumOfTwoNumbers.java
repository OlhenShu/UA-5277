package com.softserve.academy.homework.Topic5;

import java.util.Scanner;

public class SumOfTwoNumbers {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {
        String answer;
        do {
            System.out.println("Enter two numbers: ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int sum = num1 + num2;
            System.out.println("The sum of " + num1 + " and " + num2 + " is: " + sum);

            System.out.println("Do you want to continue? (yes/no)");
            answer = sc.next();

        } while (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y"));

    }
}
