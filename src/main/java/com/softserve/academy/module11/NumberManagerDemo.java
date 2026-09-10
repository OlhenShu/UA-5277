package com.softserve.academy.module11;

public class NumberManagerDemo {
    public static void main(String[] args) {
        NumberManager<Integer> integerManager = new NumberManager<>();
        integerManager.setNumber(5);
        NumberManager<Double> doubleManager = new NumberManager<>();
        doubleManager.setNumber(5.5);

        System.out.println("Integer: " + integerManager.getNumber());
        System.out.println("Double: " + doubleManager.getNumber());

        NumberManager<Byte> byteManager = new NumberManager<>();
        byteManager.setNumber((byte) 10);
        System.out.println("Byte: " + byteManager.getNumber());

    }
}
