package com.softserve.academy.module7.abst;

public class ShapesDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Rectangle(5, 3),
                new Circle(4),
                new Triangle(3, 4, 5, 7),
                new Square(4),
                new Square(3),
                new Circle(2),
        };

        for (Shape shape : shapes) {
            shape.display();
        }

    }
}
