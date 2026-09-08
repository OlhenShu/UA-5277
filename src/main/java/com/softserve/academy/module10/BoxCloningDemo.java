package com.softserve.academy.module10;

public class BoxCloningDemo {
    public static void main(String[] args) {
        Box.Payload payload = new Box.Payload("Red");
        Box box1 = new Box(10, 20, 30, payload);
        Box box2 = box1.clone();

        System.out.println("Box 1: " + box1);
        System.out.println("Box 2: " + box2);

        // Modify box2 dimensions
        box2.setWidth(40);
        box2.setHeight(50);
        box2.setDepth(60);
        box2.getPayload().setContent("Blue");

        System.out.println("After modifying Box 2:");
        System.out.println("Box 1: " + box1);
        System.out.println("Box 2: " + box2);
    }
}
