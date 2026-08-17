package com.softserve.academy.module5;

import com.softserve.academy.module3.Student;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        Student[] students = new Student[3];
        students[0] = new Student("Alice", "Green", "CS-101");
        students[1] = new Student("Bob", "Brown", "CS-102");
        students[2] = new Student("Charlie", "Black", "CS-103");

        System.out.println("Students array: " + Arrays.toString(students));

        String[][] words = {
                {"Hello", "World"},
                {"Java", "Programming", "Language", "Fundamentals", "Basics"},
                {"Array", "Demo", "Example"}
        };

        System.out.println(words[1][2]); // Output: Language
        System.out.println("2D array: " + Arrays.deepToString(words));

        int[][] table = new int[4][];
        table[0] = new int[3];
        table[1] = new int[4];
        table[2] = new int[2];
        table[3] = new int[5];

        table[0][0] = 1;
        table[0][1] = 2;
        table[0][2] = 3;
        table[1][0] = 4;
        table[1][1] = 5;
        table[1][2] = 6;
        table[1][3] = 7;

        System.out.println("2D array: " + Arrays.deepToString(table));


        Student[] studentsCopy = {
                students[0],
                students[1],
                students[2]
        };

        String[] fruits = new String[7];
        fruits[5] = "Apple";
        System.out.println(Arrays.toString(fruits));
        System.out.println("fruits[5]: " + fruits[5]);
        System.out.println("Length: " + fruits.length);
        System.out.println("Last index: " + (fruits.length - 1));
        fruits[fruits.length - 1] = "Banana";
        fruits[0] = "Orange";
        fruits[1] = "Grapes";
        fruits[2] = "Mango";
        fruits[3] = "Pineapple";
        fruits[4] = "Strawberry";
        System.out.println(Arrays.toString(fruits));


        int[] numbers = {1, 2, 3, 4, 5};

        Number[] numbersCopy = {1, 1.5, 2, 3.2, null};
        Object[] objects = {1, "Hello", 3.14, true, null, students[0]};

        System.out.println("Original array:" + Arrays.toString(numbers));
        System.out.println("Original array:");
        printArray(numbers);

        reverseArray(numbers);

        System.out.println("Reversed array:");
        printArray(numbers);

    }

    // Method to print an array
    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to reverse an array
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }
}
