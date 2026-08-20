package com.softserve.academy.module7.abst;

public class Square extends Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double getArea() {
        if (side < 0) {
            throw new IllegalArgumentException("Side length cannot be negative");
        }
        return Math.pow(side, 2);
    }

    @Override
    public double getPerimeter() {
        if (side < 0) {
            throw new IllegalArgumentException("Side length cannot be negative");
        }
        return 4 * side;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                '}';
    }
}
