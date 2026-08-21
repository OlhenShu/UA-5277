package com.softserve.academy.homework.Topic2.TaskPerson;

import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return java.time.Year.now().getValue() - birthYear;
    }

     static Scanner scanner = new Scanner(System.in);

    public void input() {

        System.out.println("Enter first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("Enter birth year: ");
        this.birthYear = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
    }

    public void output() {
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Age: " + getAge());
    }

    public void changeName() {
        System.out.println("Enter new first name: ");
        String newFirstName = scanner.nextLine();
        if (newFirstName != firstName && !newFirstName.isEmpty()) {
            firstName = newFirstName;
        }
        System.out.println("Enter new last name: ");
        String newLastName = scanner.nextLine();
        if (newLastName != lastName && !newLastName.isEmpty()) {
            lastName = newLastName;
        }
    }
}
