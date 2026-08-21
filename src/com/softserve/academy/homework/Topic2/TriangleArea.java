package com.softserve.academy.homework.Topic2;

import java.util.Scanner;

public class TriangleArea {
    static Scanner sc = new Scanner(System.in);

    public static void main() {

        double side1;
        double side2;
        double side3;

        System.out.println("Input Side 1: ");
        side1 = sc.nextDouble();

        System.out.println("Input Side 2: ");
        side2 = sc.nextDouble();

        System.out.println("Input Side 3: ");
        side3 = sc.nextDouble();

        double s = (side1 + side2 + side3) / 2;
        double area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        System.out.println("The area of the triangle is: " + area);

        sc.close();
    }
}
