package com.softserve.academy.module4;

public class ConditionalOperators {

    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Logical AND
        boolean andResult = (a < b) && (a > 0);
        System.out.println("Logical AND: " + andResult);

        // Logical OR
        boolean orResult = (a < b) || (a < 0);
        System.out.println("Logical OR: " + orResult);

        // Logical NOT
        boolean notResult = !(a < b);
        System.out.println("Logical NOT: " + notResult);

        int t = 5;
        int s = 4;
        int v = 7;
        System.out.println((t > s) && (t > v) || (s < v));
        System.out.println((t > s) || (t > v) && (s > v));
        System.out.println((t > s || t > v) && (s > v));

    }
}
