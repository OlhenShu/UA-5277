package com.softserve.academy.homework.maksym.L5_Arrays_and_Loops.Practical_task_1;

import java.util.Scanner;

    /*

    1.1. Ask the user to enter a month number (from 1 to 12).
    Using an array that stores the number of days in each month, output the number of days in the entered month.
    Count February as 28 days.
    If the entered number is outside the range 1 to 12, show an error message.
     */

public class DaysInMonth {
    static int[] daysArray = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("enter a month number (from 1 to 12)");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Please select the correct month (1-12)");
        } else {
            System.out.println(getNumberOfDays(month));
        }
        scanner.close();
    }


    public static int getNumberOfDays(int month) {
        return daysArray[month - 1];
    }

}