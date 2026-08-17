package com.softserve.academy.module4;

import java.util.Scanner;

public class YieldSwitchDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter your role (admin, user, guest):");
        String role = scanner.nextLine().toLowerCase();

        String permission = switch (role) {
            case "admin" -> {
                System.out.println("You have full access.");
                yield "Full access granted.";
            }
            case "user" -> {
                System.out.println("You have limited access.");
                yield "Limited access granted.";
            }
            case "guest" -> {
                System.out.println("You have guest access.");
                yield "Guest access granted.";
            }
            default -> {
                System.out.println("Invalid role.");
                yield "No access granted.";
            }
        };
        System.out.println(permission + " for role: " + role);
        scanner.close();
    }
}
