package com.softserve.academy.module4;

public class UnaryOperatorsDemo {
    public static void main(String[] args) {
        int a = 5;
        int b = -3;

        // Unary plus
        int positiveA = +a;
        System.out.println("Unary plus of a: " + positiveA);

        // Unary minus
        int negativeB = -b;
        System.out.println("Unary minus of b: " + negativeB);

        // Increment
        int incrementedA = ++a; // Pre-increment
        System.out.println("Pre-incremented a: " + incrementedA);
        // Post-increment
        int postIncrementedA = a++; // Post-increment
        System.out.println("Post-incremented a: " + postIncrementedA);

        // Decrement
        int decrementedB = --b; // Pre-decrement
        System.out.println("Pre-decremented b: " + decrementedB);
        // Post-decrement
        int postDecrementedB = b--; // Post-decrement
        System.out.println("Post-decremented b: " + postDecrementedB);

        //  int c = (a + b)++; // This will cause a compilation error because you cannot apply the increment operator to an expression.


    }
}
