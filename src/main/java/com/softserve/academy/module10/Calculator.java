package com.softserve.academy.module10;

/**
 * Local inner class example
 */
public class Calculator {

    public int add(int a, int b) {
        class Adder {
            public int sum(int x, int y) {
                return x + y;
            }
        }
        Adder adder = new Adder();
        return adder.sum(a, b);
    }
}
