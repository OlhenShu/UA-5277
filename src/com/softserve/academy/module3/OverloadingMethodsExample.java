package com.softserve.academy.module3;

public class OverloadingMethodsExample {

    public short add(short a, short b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return (short) (a + b);
    }

    public int add(int a, int b) {
        System.out.println("Adding two integers: " + a + " + " + b);
        return a + b;
    }

    public int add(int a, int b, int c) {
        System.out.println("Adding three integers: " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    public double add(double a, double b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }

    public double add(double a, int b) {
        System.out.println("Adding two doubles: " + a + " + " + b);
        return a + b;
    }
    public String add(int a, double b) {
        System.out.println("Adding an integer and a double: " + a + " + " + b);
        return String.valueOf((int)(a + b));
    }
    public double add(double a, double b, double c) {
        System.out.println("Adding three doubles: " + a + " + " + b + " + " + c);
        return a + b + c;
    }

    public static void main(String[] args) {
        OverloadingMethodsExample example = new OverloadingMethodsExample();
        double sum1 = example.add(5, 10);
        System.out.println("Result: " + sum1);

        double sum2 = example.add(5, 10, 15);
        System.out.println("Result: " + sum2);

        double sum3 = example.add(5.5, 10.5);
        System.out.println("Result: " + sum3);

        double sum4 = example.add(5.5, 10.5, 15.5);
        System.out.println("Result: " + sum4);
    }

//    public int add (int a, int...numbers) {
//        System.out.print("Adding one integer and a variable number of integers: " + a);
//        int sum = a;
//        for (int num : numbers) {
//            System.out.print(" + " + num);
//            sum += num;
//        }
//        System.out.println();
//        return sum;
//    }
}
