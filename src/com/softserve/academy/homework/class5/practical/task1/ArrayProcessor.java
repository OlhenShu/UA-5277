package com.softserve.academy.homework.class5.practical.task1;

import java.util.Scanner;

public class ArrayProcessor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int [] numbers = new int[10];
        int sum = 0;
        int product = 1;
        boolean allPositive = true;
        System.out.println("Enter 10 numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextInt();
        }

        for (int i = 0; i < numbers.length/2; i++) {
            if (numbers[i] >= 0) {
                sum += numbers[i];
            }else {
                allPositive = false;
                break;
            }
        }
        if (allPositive) {
            System.out.println("The sum is " + sum);
        } else {
            for (int i = numbers.length/2; i < numbers.length; i++) {
                product *= numbers[i];
            }
            System.out.println("The product is " + product);
        }

    }
}
