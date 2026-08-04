package com.softserve.academy.homework;

public class EmployeeSalary {
    public static void main(String[] args ) {
        String employeeName = "Ivan";
        double monthlySalary = 1500.0;
        int months = 12;
        double bonus = 500.0;
        double yearlySalary = (monthlySalary * months) + bonus;

        System.out.println("Employee: "+ employeeName);
        System.out.println("Monthly salary: "+ monthlySalary + " UAH.");
        System.out.println("Bonus: " + bonus + " UAH.");
        System.out.println("Yearly salary: " + yearlySalary + " UAH.");
    }
}
