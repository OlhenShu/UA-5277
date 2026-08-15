package com.softserve.academy.homework.class5.practical.task3;

public class Cars {
    private String type;
    private int yearProduction;
    private double engineCapacity;

    public Cars(String type, double engineCapacity, int yearProduction) {
        this.type = type;
        this.engineCapacity = engineCapacity;
        this.yearProduction = yearProduction;
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

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "type='" + type + '\'' +
                ", yearProduction=" + yearProduction +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
