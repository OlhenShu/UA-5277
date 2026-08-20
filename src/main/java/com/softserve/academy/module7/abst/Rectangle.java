package com.softserve.academy.module7.abst;

public class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getArea() {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative");
        }
        return length * width;
    }

    @Override
    public double getPerimeter() {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Length and width cannot be negative");
        }
        return 2 * (length + width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }
}
