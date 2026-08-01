package com.softserve.academy.homework.class3.task3;


import java.util.Scanner;

public class Person {
    private String firstName;
    private String lastName;
    private int birthYear;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }


    public int getAge() {
        return 2026 - this.birthYear;
    }

    public void input() {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        this.firstName = input.nextLine();
        System.out.print("Last Name: ");
        this.lastName = input.nextLine();
        System.out.print("Birth Year: ");
        this.birthYear = input.nextInt();
    }

    public void output() {
        System.out.println("Person: " +
                "\nFirst Name='" + firstName +
                ",\nLast Name='" + lastName +
                ",\nAge=" + getAge());
    }

    public void changeName() {
        Scanner input = new Scanner(System.in);
        System.out.print("First Name: ");
        String fn = input.nextLine();
        if (fn.isEmpty()) {

        } else {
            this.firstName = fn;
        }

        System.out.print("Last Name: ");
        String ln = input.nextLine();
        if (ln.isEmpty()) {

        } else {
            this.lastName = ln;
        }

    }

}
