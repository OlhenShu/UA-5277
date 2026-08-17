package com.softserve.academy.module4;

import java.util.Scanner;

public class DialogSwitchDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Do you want to continue?");

        String response = scanner.nextLine();

        switch (response.toLowerCase()) {
            case "y":
            case "yes":
                System.out.println("You chose to continue.");
                break;
            case "n":
            case "no":
                System.out.println("You chose not to continue.");
                break;
            default:
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
        }

        String response2 = scanner.nextLine();
        String result = switch (response2.toLowerCase()) {
            case "y", "yes" -> "You chose to continue.";
            case "n", "no" -> "You chose not to continue.";
            default -> "Invalid input. Please enter 'yes' or 'no'.";
        };
        System.out.println(result);

        scanner.close();
    }
}
