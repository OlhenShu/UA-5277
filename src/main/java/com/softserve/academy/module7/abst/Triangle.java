package com.softserve.academy.module7.abst;

public class Triangle extends Shape {
    private double base;
    private double height;
    private double sideA;
    private double sideB;

    public Triangle(double base, double sideA, double sideB) {
        this.base = base;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Triangle(double base, double height, double sideA, double sideB) {
        this.base = base;
        this.height = height;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    @Override
    public double getArea() {
        if (base < 0 || height < 0) {
            throw new IllegalArgumentException("Base and height cannot be negative");
        }
        if (!isValidTriangle()) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        if (base < 0 || sideA < 0 || sideB < 0) {
            throw new IllegalArgumentException("Sides cannot be negative");
        }
        if (!isValidTriangle()) {
            throw new IllegalArgumentException("Invalid triangle sides");
        }
        return base + sideA + sideB;
    }

    public boolean isValidTriangle() {
        return (sideA + sideB > base) && (sideA + base > sideB) && (sideB + base > sideA);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", height=" + height +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}
