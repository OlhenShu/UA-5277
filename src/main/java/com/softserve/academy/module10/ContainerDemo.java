package com.softserve.academy.module10;

public class ContainerDemo {

    public static void main(String[] args) {
        // Create using named outer object
        Container container = new Container(65);
        Container.Label label = container.new Label("My Container");
        container.printInfo();
        label.print();

        Container.Label label2 = new Container(25).new Label("Another Label");
        label2.print();

        Shape.Coordinates coordinate = new Shape.Coordinates(10, 20);
        System.out.println("Coordinates: " + coordinate.x() + ", " + coordinate.y());
        System.out.println("Coordinates: " + coordinate);

    }
}
