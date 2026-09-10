package com.softserve.academy.module11;

public class BoxDemo {
    public static void main(String[] args) {
        Box<String, String> stringBox = new Box<>();
        stringBox.setValue("Hello, World!");
        stringBox.setLabel("Greeting");
        System.out.println("String Box contains: " + stringBox.getValue() + " with label: " + stringBox.getLabel());

        Box<Integer, String> integerBox = new Box<>();
        integerBox.setValue(42);
        integerBox.setLabel("Answer to the Ultimate Question");
        System.out.println("Integer Box contains: " + integerBox.getValue() + " with label: " + integerBox.getLabel());

        Box<Double, Boolean> doubleBox = new Box<>();
        doubleBox.setValue(3.14);
        doubleBox.setLabel(true);
        System.out.println("Double Box contains: " + doubleBox.getValue() + " with label: " + doubleBox.getLabel());

//        WraperBox wraperBox = new WraperBox();
//        int value = 123;
//        wraperBox.setBox(String.valueOf(value));
//        System.out.println("WraperBox contains: " + wraperBox.getBox());


    }
}
