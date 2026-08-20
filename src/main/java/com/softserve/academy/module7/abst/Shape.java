package com.softserve.academy.module7.abst;

public abstract class Shape {

    public abstract double getArea();

    public abstract double getPerimeter();

    public void display() {
        System.out.println("Shape: " + this.getClass().getSimpleName());
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("-------------------------");
    }
}
