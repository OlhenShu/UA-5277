package com.softserve.academy.module8;

public class Director implements Worker, GetContracts {
    private PersonalInfo personalInfo;
    private int salary;
    private String position;
    private boolean fullTime;

    public Director(PersonalInfo personalInfo, int salary, String position, boolean fullTime) {
        this.personalInfo = personalInfo;
        this.salary = salary;
        this.position = position;
        this.fullTime = fullTime;
    }

    @Override
    public int getSalary() {
        return 3000 + salary;
    }

    @Override
    public String getPosition() {
        return personalInfo.name() + " " + personalInfo.surname() + " - " + position;
    }

    @Override
    public boolean isFullTime() {
        return fullTime;
    }

    @Override
    public String getContract() {
        return "Director Contract";
    }
}
