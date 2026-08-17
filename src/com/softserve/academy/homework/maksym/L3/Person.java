package com.softserve.academy.homework.maksym.L3;

import java.time.Year;
import java.util.Scanner;

public class Person {
    int currentYear = Year.now().getValue();
    private String firstname;
    private String lastName;
    private int birthYear;

    //CONSTRUCTORS
    public Person() {
    }

    public Person(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    //METHODS
    public int getAge() {
        return currentYear - birthYear;
    }  //DONE

    public void input(Scanner scanner) {
        System.out.print("What is your First Name?: ");
        this.firstname = scanner.nextLine();
        System.out.print("What is your Second Name?: ");
        this.lastName = scanner.nextLine();
        System.out.print("What is your Birth Year?: ");
        this.birthYear = scanner.nextInt();
        System.out.println("Person updated: " + this.firstname + " " + this.lastName + " " + this.birthYear);
        System.out.println("___________________________________");
        scanner.nextLine();

    }

    public void output() {
        System.out.printf("""
                ________________________
                Person Info:
                > Full name: %s %s
                > Age: %d
                ________________________
                """, this.firstname, this.lastName, getAge());
    }

    public void changeName(String fn, String ln) {
        this.firstname = fn;
        this.lastName = ln;
    }

    //GETTERS AND SETTERS
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
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
}
