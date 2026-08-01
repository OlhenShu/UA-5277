package com.softserve.academy.homework.class3;

import java.util.Scanner;

public class CalculateArea {
    public static void main(String[] args) {
        areaTriangle();
    }

    public static void areaTriangle() {
        int side1, side2, side3;
        double p;
        double area;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input side 1: ");
        side1 = scanner.nextInt();
        System.out.print("Input side 2: ");
        side2 = scanner.nextInt();
        System.out.print("Input side 3: ");
        side3 = scanner.nextInt();
        p = (double) (side1 + side2 + side3) / 2;
        area = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
        System.out.printf("Area of Triangle is: %.2f%n", area);
    }

}
