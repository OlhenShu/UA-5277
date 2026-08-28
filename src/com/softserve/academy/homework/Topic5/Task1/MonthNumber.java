package com.softserve.academy.homework.Topic5.Task1;

import java.util.Scanner;

public class MonthNumber {
   static Scanner scanner = new Scanner(System.in);
    static int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {

        System.out.println("Enter month number (1-12): ");
        int monthNumber = scanner.nextInt();
        if (monthNumber < 1 || monthNumber > 12) {
            System.out.println("Month number must be between 1 and 12.");
        } else {
            System.out.println("Number of days in month " + monthNumber + ": " + daysInMonth[monthNumber - 1]);
        }
    }
}
