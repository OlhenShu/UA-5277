package com.softserve.academy.homework.class5.practical;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Random rand = new Random();
        int counter = 0;
        int randomNumber = rand.nextInt(100) + 1;
        System.out.println("Guess a number between 1 and 100");
        int guessNumber;
        do {
            guessNumber = sc.nextInt();
            if (guessNumber > 100 || guessNumber < 1) {
                System.out.println("Guess a number between 1 and 100");
                continue;
            }
            if (guessNumber == randomNumber) {
                counter++;
                System.out.println(" Your guess number!  Number of attempts: " + counter);
                break;
            }
            if (guessNumber > randomNumber) {
                System.out.println("Too high, try again.");
                counter++;

            } else {
                System.out.println("Too low, try again.");
                counter++;
            }
        } while (guessNumber != randomNumber);


    }
}
