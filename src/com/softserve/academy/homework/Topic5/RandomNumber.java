package com.softserve.academy.homework.Topic5;

import java.util.Scanner;

public class RandomNumber {
    static Scanner sc = new Scanner(System.in);

    static void main(String[] args) {

        int num;
        int randomNum = (int) (Math.random() * 100 + 1);
        int count = 1;
        do {
            System.out.println("Enter a number: ");
            num = sc.nextInt();

            if (num > randomNum) {
                System.out.println("Too high, try again..");
                count++;

            } else if (num < randomNum) {
                System.out.println("Too low, try again..");
                count++;

            } else {
                System.out.println("Random number is: " + randomNum);
                System.out.println("Congratulations! You guessed the number. Number of attempts: " + count);
            }

        } while (num != randomNum);
    }
}