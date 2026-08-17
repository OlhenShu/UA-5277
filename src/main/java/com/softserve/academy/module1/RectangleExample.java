package com.softserve.academy.module1;

import java.awt.*;

public class RectangleExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(30, 15);
        System.out.println("Rectangle: " + rectangle);

        boolean isPresent = true;
        System.out.println("Is rectangle present: " + isPresent);

        double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        System.out.println("Perimeter of rectangle: " + perimeter);
    }
}
