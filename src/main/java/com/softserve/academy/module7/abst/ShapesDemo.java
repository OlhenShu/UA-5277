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
//
//        for (Shape shape : shapes) {
//            shape.display();
//        }
        Circle circle = new Circle(5);
        Shape shape = (Shape) circle; // Upcasting Circle to Shape is allowed because Circle is a subclass of Shape.
        shape.display();

        circle.printCircleInfo();
        // shape.printCircleInfo();// The above line will cause a compile-time error because the printCircleInfo() method is not defined in the Shape class.
        ((Circle) shape).printCircleInfo();

        //instanceof check
        if (shape instanceof Circle) {
            Circle circle1 = (Circle) shape; // Downcasting Shape to Circle is allowed because shape is actually a Circle object.
            circle1.printCircleInfo();
        } else {
            System.out.println("The shape is not a Circle.");
        }
    }
}
