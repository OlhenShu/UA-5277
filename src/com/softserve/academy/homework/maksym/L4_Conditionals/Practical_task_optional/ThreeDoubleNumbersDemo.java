package com.softserve.academy.homework.maksym.L4_Conditionals.Practical_task_optional;

import java.util.Scanner;

public class ThreeDoubleNumbersDemo {
    static void main() {
        double num1 = 0;
        double num2 = 0;
        double num3 = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input three double numbers [Format X,XXX...].");
            System.out.print("Enter number #1 :");
            num1 = scanner.nextDouble();
            System.out.print("Enter number #2 :");
            num2 = scanner.nextDouble();
            System.out.print("Enter number #3 :");
            num3 = scanner.nextDouble();
            scanner.close();
        } catch (Exception e) {
            System.out.println("Some error occurred");
        }

        if ((num1 <= 5.0 && num1 >= -5.0) && (num2 <= 5.0 && num2 >= -5.0) && (num3 <= 5.0 && num3 >= -5.0)) {
            System.out.println("All three numbers belong to the range [-5, 5]");
        } else {
            System.out.println("Not all numbers belong to the range [-5, 5].");
        }


    }
}
