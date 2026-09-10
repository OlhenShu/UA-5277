package com.softserve.academy.module11;

public class NumberManager<T extends Number> {
    private T number;

    public NumberManager() {
    }

    public NumberManager(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }

    public int intValue() {
        return number.intValue();
    }
}
