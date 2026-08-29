package com.softserve.academy.homework.maksym.L5_Arrays_and_Loops;

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] array = {12, -20, 35, 64, -5, -60, 17, 32, 84, 100};
        System.out.println(calculateSum(array));
    }

    public static int calculateSum(int[] array) {
        return Arrays.stream(array).sum();
    }
}

