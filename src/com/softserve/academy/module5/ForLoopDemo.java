package com.softserve.academy.module5;

import java.util.Arrays;

public class ForLoopDemo {
    public static void main(String[] args) {
        int[] numbers = {11, -2, 38, 74, 85, 92, 44, 68, 52, 100, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int i = 1; i < numbers.length; i += 2) {
            System.out.print("number = " + numbers[i] + "\n");
            numbers[i] += 5;
        }
        System.out.println(Arrays.toString(numbers));

        System.out.println("--------------------------------------------------");

        for (int nums : numbers) {
            System.out.print("number = " + (nums + 5) + "\n");
            nums += 5;
        }

        //  Arrays.sort(numbers);
        System.out.println("numbers: " + Arrays.toString(numbers));

    }
}
