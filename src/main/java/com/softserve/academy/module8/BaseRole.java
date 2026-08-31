package com.softserve.academy.module8;

public abstract class BaseRole implements Worker, GetContracts {
    protected PersonalInfo personalInfo;
    protected int salary;
    protected String position;
    protected boolean fullTime;

    BaseRole(PersonalInfo personalInfo, int salary, String position, boolean fullTime) {
        this.personalInfo = personalInfo;
        this.salary = salary;
        this.position = position;
        this.fullTime = fullTime;
    }

}
