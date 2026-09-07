package com.softserve.academy.module9;

import java.io.BufferedReader;
import java.io.FileReader;

public class ExceptionExample {
    public static void main(String[] args) {

        try {
            int result = divide(10, "123");
            System.out.println("Result: " + result);
        } catch (ArithmeticException | ClassCastException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General error: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
        try {
            String[] words = {"Hello", "World"};
            System.out.println(words[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        try (FileReader fr = new FileReader("nonexistent_file.txt")) {
            readFile("nonexistent_file.txt");
        } catch (Exception e) {
            System.out.println("File not found: " + e.getMessage());
        }
        System.out.println("Program continues...");

        for (int i = 0; i < 5; i++) {
            try {
                if (i == 3) {
                    throw new Exception("Custom exception at i = " + i);
                }
                System.out.println("i = " + i);
            } catch (Exception e) {
                System.out.println("Caught exception: " + e.getMessage());
            }
        }

    }

    private static int divide(int a, Object b) {
        return a / (int) b;
    }

    private static void readFile(String filePath) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
    }
}
