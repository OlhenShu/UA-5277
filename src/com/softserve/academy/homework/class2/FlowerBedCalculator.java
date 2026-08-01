package com.softserve.academy.homework.class2;

import java.util.Scanner;

public class FlowerBedCalculator {
    public static void main(String[] args) {
        int radius = 10;
        double perimeter;
        double area;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius: ");
        radius = input.nextInt();

        perimeter = 2 * Math.PI * radius;
        area = Math.PI * radius * radius;
        System.out.println("Perimeter: " + perimeter);
        System.out.println("Area: " + area);
    }
}
