package com.softserve.academy.module4;

import java.util.Scanner;

public class DiscountSwitchDemo {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введіть рівень клієнта (платинум, голд, сілвер, новий):");
        String level = scanner.nextLine().toLowerCase();

        double discount = switch (level) {
            case "платинум" -> 0.20; // 20% знижки
            case "голд" -> 0.15;     // 15% знижки
            case "сілвер" -> 0.10;    // 10% знижки
            case "новий" -> 0.05;     // 5% знижки
            default -> {
                System.out.println("Невідомий рівень клієнта.");
                yield 0.0;
            }
        };

        System.out.println("Ваша знижка: " + (discount * 100) + "%");
        scanner.close();
    }
}
