package com.softserve.academy.module10;

import java.util.Arrays;

public class Shape {
    private String type;
    private Coordinates[] coordinates;

    public Shape(String type, Coordinates[] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public Coordinates[] getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "type='" + type + '\'' +
                ", coordinates=" + Arrays.toString(coordinates) +
                '}';
    }
//    static class Coordinates {
//        private int x;
//        private int y;
//
//        public Coordinates(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//
//        public int getX() {
//            return x;
//        }
//
//        public int getY() {
//            return y;
//        }
//    }

    public record Coordinates(int x, int y) {
    }
}
