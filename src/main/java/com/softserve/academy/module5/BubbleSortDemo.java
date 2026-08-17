package com.softserve.academy.module5;

import java.util.Arrays;

public class BubbleSortDemo {
    public static void main(String[] args) {
        int[] numbers = {11, -2, 38, 74, -85, 92, -44, 68, 52, 100, 10, 32};
        System.out.println("Original array: " + Arrays.toString(numbers));

        int index1 = Arrays.binarySearch(numbers, 68);
        System.out.println("Index of 68 in the original array: " + index1);


        //sort the array using bubble sort
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    //swap numbers[j] and numbers[j + 1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        System.out.println("Sorted array: " + Arrays.toString(numbers));

        int index = Arrays.binarySearch(numbers, 68);
        System.out.println("Index of 68 in the sorted array: " + index);
    }
}
