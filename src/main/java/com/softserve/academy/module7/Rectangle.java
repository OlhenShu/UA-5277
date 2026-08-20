package com.softserve.academy.module7;

import java.util.Objects;

public class Rectangle {
    private double length;
    private double width;


    public Rectangle() {
        this.length = 0;
        this.width = 0;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    /**
     * Calculates and returns the perimeter of a rectangle.
     * The perimeter is calculated as 2 times the sum of the length and width.
     * If the length or width is negative, the method returns -1.
     *
     * @return the perimeter of the rectangle, or -1 if length or width is negative
     */
    protected double getPerimeter() {
        if (length < 0 || width < 0) {
            return -1;
        }
        return 2 * (length + width);
    }

    /**
     * Calculates and returns the area of a rectangle.
     * The area is calculated as the product of the length and width.
     * If the length or width is negative, the method returns -1.
     *
     * @return the area of the rectangle, or -1 if length or width is negative
     */
    public double getArea() {
        if (length < 0 || width < 0) {
            return -1;
        }
        return length * width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(length, rectangle.length) == 0 && Double.compare(width, rectangle.width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                '}';
    }


}
