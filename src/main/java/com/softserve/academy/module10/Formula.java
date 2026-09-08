package com.softserve.academy.module10;

public interface Formula {
    double calculate(int a);

    String getFormulaName();

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
