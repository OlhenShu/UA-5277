package com.softserve.academy.homework.maksym.L3;

import java.util.Scanner;

public class AreaOfATriangle {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the lengths of side A (mm) : ");
        int a = scanner.nextInt();
        System.out.print("Enter the lengths of side B (mm) : ");
        int b = scanner.nextInt();
        System.out.print("Enter the lengths of side C (mm) : ");
        int c = scanner.nextInt();
        double s = AreaCalc.getArea(a, b, c);

        System.out.printf("""
                Input Side 1: %d
                Input Side 2: %d
                Input Side 3: %d
                The area of the triangle is %.2f
                
                """, a, b, c, s);
        scanner.close();
    }


}

class AreaCalc {
    public static double getArea(int a, int b, int c) {
        double p = (double) (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
