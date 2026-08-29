package com.softserve.academy.homework.maksym.L5_Arrays_and_Loops.Practical_task_1;

import java.util.Scanner;

public class ArrayCalculation {


    /*
    1.2. Ask the user to enter 10 integers into an array.
    If all five first elements are positive, calculate and output the sum of these five elements.
    Otherwise, calculate and output the product of the five last elements.
     */
    static void main() {
        int[] array = new int[10];
        boolean fiveFirstPositive = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter 10 integers");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < 5; i++) {
            if (array[i] <= 0) {
                fiveFirstPositive = false;
            }
        }

        if (fiveFirstPositive) {
            System.out.println(getArraySum(array));
        } else System.out.println(getArrayProduct(array));


        scanner.close();

    }


    public static int getArraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            sum += array[i];
            ;
        }
        return sum;
    }

    public static int getArrayProduct(int[] array) {
        int sum = 1;
        for (int i = array.length - 1; i >= 5; i--) {
            sum *= array[i];
        }
        return sum;
    }
}
