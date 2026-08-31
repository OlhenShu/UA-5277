package com.softserve.academy.module8;

public class Administrator extends BaseRole {
    public Administrator(PersonalInfo personalInfo, int salary, String position, boolean fullTime) {
        super(personalInfo, salary, position, fullTime);
    }

    @Override
    public int getSalary() {
        return 800 + salary;
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
        return "Administrator Contract";
    }
}
