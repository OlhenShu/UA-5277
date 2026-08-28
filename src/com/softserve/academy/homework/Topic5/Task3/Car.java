package com.softserve.academy.homework.Topic5.Task3;

import java.util.Scanner;

public class Car {
    private String type;
    private int year;
    private double engineCapacity;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Car[] cars = new Car[4];
        cars[0] = new Car("Sedan", 2020, 2.0);
        cars[1] = new Car("SUV", 2019, 2.5);
        cars[2] = new Car("Hatchback", 2021, 1.6);
        cars[3] = new Car("Coupe", 2016, 3.0);

        System.out.println("Enter a year of a car:");
        int inputYear = sc.nextInt();

        boolean found = false;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getYear() == inputYear) {
                System.out.println("Car found: " + cars[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No car found for the given year.");
        }

        for (int i = 0; i < cars.length - 1; i++) {
            for (int j = 0; j < cars.length - 1 - i; j++) {
                if (cars[j].getYear() > cars[j + 1].getYear()) {
                    Car temp = cars[j];
                    cars[j] = cars[j + 1];
                    cars[j + 1] = temp;
                }
            }
        }

        System.out.println("Cars sorted by year:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    public Car() {
        this.type = "Unknown";
        this.year = 0;
        this.engineCapacity = 0.0;
    }

    public Car(String type, int year, double engineCapacity) {
        this.type = type;
        this.year = year;
        this.engineCapacity = engineCapacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Type: " + type +
                ", year: " + year +
                ", engineCapacity: " + engineCapacity;
    }
}