package com.softserve.academy.module7;

public class DemoShapes {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 3);
        System.out.println("Rectangle perimeter: " + rectangle.getPerimeter());
        System.out.println("Rectangle area: " + rectangle.getArea());

        Parallelogram parallelogram = new Parallelogram(4, 2, 60);
        System.out.println("Parallelogram perimeter: " + parallelogram.getPerimeter());
        System.out.println("Parallelogram area: " + parallelogram.getArea());
    }
}
