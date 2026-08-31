package com.softserve.academy.module8;

public class Manager implements Worker {
    private PersonalInfo personalInfo;
    private int salary;
    private String position;
    private boolean fullTime;

    public Manager(PersonalInfo personalInfo, int salary, String position, boolean fullTime) {
        this.personalInfo = personalInfo;
        this.salary = salary;
        this.position = position;
        this.fullTime = fullTime;
    }

//    @Override
//    public double getSalary(String position) {
//        if (position.equalsIgnoreCase("Manager")) {
//            return 1500.0 + salary;
//        }
//        return 0;
//    }

    @Override
    public int getSalary() {
        return 1500 + salary;
    }

    @Override
    public String getPosition() {
        return personalInfo.name() + " " + personalInfo.surname() + " - " + position + " " + personalInfo.email();
    }

    @Override
    public boolean isFullTime() {
        return fullTime;
    }
}
