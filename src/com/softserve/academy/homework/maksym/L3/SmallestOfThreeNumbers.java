package com.softserve.academy.homework.maksym.L3;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    static void main() {


        Scanner scanner = new Scanner(System.in);
        System.out.print("Input the first number : ");
        int first = scanner.nextInt();

        System.out.print("Input the second number : ");
        int second = scanner.nextInt();

        System.out.print("Input the third number : ");
        int third = scanner.nextInt();


        System.out.printf("""
                *************** RESULT ***************
                Input the first number: %d
                Input the second number: %d
                Input the third number: %d
                **************************************""", first, second, third);
        System.out.println("\nThe smallest number is " + GetSmallestNum.getSmallest(first, second, third));


        scanner.close();


    }

    static class GetSmallestNum {
        public static int getSmallest(int first, int second, int third) {
            int smallest = first;
            if (second < smallest) {
                smallest = second;
            }
            if (third < smallest) {
                smallest = third;
            }
            return smallest;
        }
    }

}
