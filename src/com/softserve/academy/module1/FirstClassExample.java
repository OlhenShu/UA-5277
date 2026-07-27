package com.softserve.academy.module1;

public class FirstClassExample {

    public static void main(String[] args) {

        //Primitive data types
        boolean isTrue = true; // boolean data type, 1 bit, true or false
        char letter = '1'; // char data type, 2 bytes, single character
        byte smallNumber = 127; // byte data type, 1 byte, -128 to 127
        short mediumNumber = 32767; // short data type, 2 bytes, -32768 to 32767
        int number = 2147483647; // int data type, 4 bytes, -2147483648 to 2147483647
        long bigNumber = 9223372036854775807L; // long data type, 8 bytes, -9223372036854775808 to 9223372036854775807
        float floatNumber = 3.14f; // float data type, 4 bytes, single-precision floating point
        double doubleNumber = 3.141592653589793; // double data type, 8 bytes, double-precision floating point

        System.out.println("Primitive data types:");
        System.out.println("boolean: " + isTrue);
        System.out.println("char: " + letter);
        System.out.println("byte: " + smallNumber);
        System.out.println("short: " + mediumNumber);
        System.out.println("int: " + number);
        System.out.println("long: " + bigNumber);
        System.out.println("float: " + floatNumber);
        System.out.println("double: " + doubleNumber);

        // Reference data types
        String text = "Hello, World!"; // String data type, a sequence of characters
        FirstClassExample example = new FirstClassExample(); // Reference to an object of the class
        int[] numbers = {1, 2, 3, 4, 5}; // Array of integers
        System.out.println("Reference data types:");
        System.out.println("String: " + text);
        System.out.println("Object reference: " + example);
        System.out.println("Array: " + numbers);

        int a = 15;
        int b = 2;
        int c =  a / b;
        System.out.println((double)c);
        System.out.println(15/2);
        System.out.println("div of a \\ b is: " +  a + b);
    }
}


