package com.softserve.academy.module8;

public class WorkerDemo {
    public static void main(String[] args) {
        PersonalInfo personalInfo1 = new PersonalInfo("John", "Doe", 30, "john.doe@example.com");
        PersonalInfo personalInfo2 = new PersonalInfo("Jane", "Smith", 25, "jane.smith@example.com");

//        Director director = new Director(personalInfo1, 3000, "Director", true);
//
//        Worker[] workers = {
//                new Manager(personalInfo1, 2000, "Director", true),
//                new Director(personalInfo2, 3000, "Director", false),
//                new Manager(personalInfo2, 1000, "Manager", true)
//        };
//
//        for (Worker worker : workers) {
//            System.out.println("Position: " + worker.getPosition());
//            System.out.println("Salary: " + worker.getSalary());
//            System.out.println("Is full time: " + worker.isFullTime());
//            System.out.println("-----------------------------");
//        }
//
//        director.printContractDetails(); // Call the default method from GetContracts interface
//
//        BaseRole[] roles = {
//                new Administrator(personalInfo1, 2000, "Administrator", true),
//                new Developer(personalInfo2, 3000, "Java Developer", false),
//                new Administrator(personalInfo1, 1000, "Security Administrator", true),
//                new Developer(personalInfo2, 1500, "Frontend Developer", true)};
//
//
//        for (BaseRole role : roles) {
//            System.out.println("Position: " + role.getPosition());
//            System.out.println("Salary: " + role.getSalary());
//            System.out.println("Is full time: " + role.isFullTime());
//            role.printContractDetails(); // Call the default method from GetContracts interface
//            System.out.println("-----------------------------");
//
//        }

        Object[] employees = {
                new Manager(personalInfo1, 2000, "Manager", true),
                new Director(personalInfo2, 3000, "Director", false),
                new Manager(personalInfo2, 1000, "Manager", true),
                new Administrator(personalInfo1, 2000, "Administrator", true),
                new Developer(personalInfo2, 3000, "Java Developer", false)
        };

        for (Object employee : employees) {
            if (employee instanceof Worker worker) {
                System.out.println("Position: " + worker.getPosition());
                System.out.println("*-*".repeat(30));
            }

            if (employee instanceof GetContracts contractWorker) {
                contractWorker.printContractDetails(); // Call the default method from GetContracts interface
            }
            System.out.println("-----------------------------");
        }
    }
}
