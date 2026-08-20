package com.softserve.academy.module7.abst;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative");
        }
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

}
