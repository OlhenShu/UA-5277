package com.softserve.academy.module1;

import java.util.Scanner;

public class ReadWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first word:");
        String firstWord = scanner.next();
        System.out.println("Enter the second word:");
        String secondWord = scanner.next();
        System.out.println("Enter the third word:");
        String thirdWord = scanner.next();
        System.out.println("You entered the following words:");
        System.out.println("Third word: " + thirdWord);
        System.out.println("Second word: " + secondWord);
        System.out.println("First word: " + firstWord);

       scanner.close();
    }
}
