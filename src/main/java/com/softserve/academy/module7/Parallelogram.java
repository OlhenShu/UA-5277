package com.softserve.academy.module7;

import java.util.Objects;

public class Parallelogram extends Rectangle {
    private int angle;

    public Parallelogram() {
        super();
        this.angle = 0;
    }

    public Parallelogram(double length, double width, int angle) {
        super(length, width);
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    /**
     * Calculates and returns the area of a parallelogram.
     * The area is calculated as the product of the length, width, and the sine of the angle (in radians).
     * If the length or width is negative, or if the angle is not in the range (0, 180), the method returns -1.
     *
     * @return the area of the parallelogram, or -1 if length, width, or angle is invalid
     */
    @Override
    public double getArea() {
        if (getLength() < 0 || getWidth() < 0 || angle <= 0 || angle >= 180) {
            return -1;
        }
        return getLength() * getWidth() * Math.sin(Math.toRadians(angle));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Parallelogram that = (Parallelogram) o;
        return angle == that.angle;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), angle);
    }

    @Override
    public String toString() {
        return "Parallelogram{" +
                "angle=" + angle +
                '}';
    }
}
