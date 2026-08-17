package com.softserve.academy.module4;

import java.util.Scanner;

public class SwitchDemo {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter a number between 1 and 7 to get the corresponding day of the week:");

        int day = scanner.nextInt();

        switch (day) {
            case 1:
            case 2:
                System.out.println("Monday or Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
        }

        scanner.close();
    }
}
