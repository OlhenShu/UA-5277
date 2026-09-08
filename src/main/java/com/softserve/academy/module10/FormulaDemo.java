package com.softserve.academy.module10;

public class FormulaDemo {
    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return Math.sqrt(a * 100);
            }

            @Override
            public String getFormulaName() {
                return "Square Root of (a * 100)";
            }
        };

        System.out.println(formula.calculate(17));
        System.out.println(formula.sqrt(16));

    }
}
