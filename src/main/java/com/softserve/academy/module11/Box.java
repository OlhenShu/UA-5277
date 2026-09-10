package com.softserve.academy.module11;

public class Box<A, U> {
    private A value;
    private U label;

    public A getValue() {
        return value;
    }

    public void setValue(A value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
        this.value = value;


    }

    public U getLabel() {
        return label;
    }

    public void setLabel(U label) {
        if (label == null) {
            throw new IllegalArgumentException("Label cannot be null");
        }
        this.label = label;
    }
}
