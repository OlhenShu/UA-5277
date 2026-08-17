package com.softserve.academy.module5;

import java.util.Arrays;

public class OperationsAbouveArrayDemo {
    public static void main(String[] args) {
        int[] numbers = {131, -2, 38, -89, 74, 131, 85, 92, 44, 68, 52, 100, 1, 2, 3, 4, 5, 6, 7, -89, 8, 9, 10};

        //filter numbers greater than 50  and less than 90, and print them with their indexes
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 50 && numbers[i] < 90) {
                System.out.println("number = " + numbers[i] + " index = " + i);
            }
        }
        //sum of numbers in the array
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println("Sum of numbers in the array: " + sum);

        //product of numbers in the array, skipping zeros
        int product = 1;
        for (int number : numbers) {
            if (number == 0) {
                continue; // Skip multiplication by zero
            }
            product *= number;
        }
        System.out.println("Product of numbers in the array: " + product);

        //count of numbers between 1 and 9
        int count = 0;
        for (int number : numbers) {
            if (number > 0 && number < 10) {
                count++;
            }
        }
        System.out.println("Count of numbers between 1 and 9: " + count);

        // Find the maximum and minimum numbers in the array
        int max = numbers[0];
        int min = numbers[0];

        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                indexMax = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                indexMin = i;
            }
        }
        System.out.println("Maximum number in the array: " + max + " at index " + indexMax);
        System.out.println("Minimum number in the array: " + min + " at index " + indexMin);

        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        System.out.println("Sorted array: " + Arrays.toString(sortedNumbers));

        int maxSorted = sortedNumbers[sortedNumbers.length - 1];
        int minSorted = sortedNumbers[0];
        System.out.println("Maximum number in the sorted array: " + maxSorted);
        System.out.println("Minimum number in the sorted array: " + minSorted);

        int size = numbers.length;
        System.out.println("Size of the array: " + size);

    }
}