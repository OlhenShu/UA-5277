package com.softserve.academy.module8;

public class Developer extends BaseRole {
    public Developer(PersonalInfo personalInfo, int salary, String position, boolean fullTime) {
        super(personalInfo, salary, position, fullTime);
    }

    @Override
    public int getSalary() {
        return 1200 + salary;
    }

    @Override
    public String getPosition() {
        return personalInfo.email() + " - " + position;
    }

    @Override
    public boolean isFullTime() {
        return fullTime;
    }

    @Override
    public String getContract() {
        return "Developer Contract";
    }
}
