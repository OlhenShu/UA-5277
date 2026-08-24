package com.softserve.academy.module7;

public class PrimitiveTypesCastingDemo {
    public static void main(String[] args) {
        short s = 10;
        int i = s; // implicit casting (short to int)
        System.out.println("Implicit casting (short to int): " + i);
        long l = i; // implicit casting (int to long)
        System.out.println("Implicit casting (int to long): " + l);

        double d = 100.52;
        long l2 = (long) d; // explicit casting (double to long)
        System.out.println("Explicit casting (double to long): " + l2);

        int i2 = -2147483648 / 25;//Integer.MIN_VALUE;
        System.out.println(i2);
        short s2 = (short) i2; // explicit casting (int to short)
        System.out.println("Explicit casting (int to short): " + s2);
    }
}
