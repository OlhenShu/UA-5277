package com.softserve.academy.homework.Task1;

import java.util.Scanner;

public class FlowerBedCalculator {
    static Scanner sc = new Scanner(System.in);

    static void main() {

        int radius;

        System.out.println("Введіть радіус: ");
        radius = sc.nextInt();

        double perimeter = 2 * Math.PI * radius;
        System.out.println("Периметр: " + perimeter);

        double area = Math.PI * radius * radius;
        System.out.println("Площа: " + area);

        sc.close();
    }

}
