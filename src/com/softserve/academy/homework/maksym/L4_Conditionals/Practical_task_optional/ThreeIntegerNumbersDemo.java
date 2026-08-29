package com.softserve.academy.homework.maksym.L4_Conditionals.Practical_task_optional;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThreeIntegerNumbersDemo {
    static void main() {
        int num1;
        int num2;
        int num3;
        int maxNumber;
        int minNumber;

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please input three whole numbers.");
            System.out.print("Enter number #1 :");
            num1 = scanner.nextInt();
            System.out.print("Enter number #2 :");
            num2 = scanner.nextInt();
            System.out.print("Enter number #3 :");
            num3 = scanner.nextInt();
            scanner.close();
            maxNumber = Math.max(num1, Math.max(num2, num3));
            minNumber = Math.min(num1, Math.min(num2, num3));

            System.out.printf("""
                    Max number is: %d
                    Min number is: %d
                    """, maxNumber, minNumber);


        } catch (InputMismatchException e) {
            System.out.println("Please use only Integer numbers");
        } catch (Exception e) {
            System.out.println("Some error occurred -->  " + e);
        }


    }
}
