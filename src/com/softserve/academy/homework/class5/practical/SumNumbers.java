package com.softserve.academy.homework.class5.practical;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int sum;
        int number1;
        int number2;
        String answer;
        do {
            System.out.println("Enter first and second numbers: ");
            number1 = input.nextInt();
            number2 = input.nextInt();
            sum = number1 + number2;
            System.out.println("The sum is: " + sum);
            input.nextLine();
            do {
                System.out.println("Do you want to continue? y/n: ");
                answer = input.nextLine();
                if (answer.equalsIgnoreCase("n")) {
                    break;
                }
            }
            while (!answer.equalsIgnoreCase("y"));
        } while (answer.equalsIgnoreCase("y"));
    }
}
