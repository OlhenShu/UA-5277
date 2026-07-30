package com.softserve.academy.module3;

public class Student {
    private String name;
    private String lastName;
    private int age;
    private String group;

    public Student() {
        this.name = "";
        this.lastName = "";
        this.age = 0;
        this.group = "";
    }

    public Student(String firstName, String lastName, int age, String group) {
        this.name = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    public Student(String firstName, String lastName, String group) {
        this.name = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    /**
     * Prints the student information to the console.
     */
    public  void printStudentInfo() {
        System.out.println("Student Info:" + "\n"
                + "First Name: " + name + "\n"
                + "Last Name: " + lastName + "\n"
                + "Age: " + age + "\n"
                + "Group: " + group);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the age of the student. If the provided age is negative, it sets the age to 0 and prints a warning message.
     * @param age The age of the student.
     */
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Setting age to 0.");
            this.age = 0;
        }
    }

    @Override
    public String toString() {
        return "Student full information " +
                "firstame='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", group='" + group + '\'';
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isStudent() {
        return true;
    }

    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public String getFullName() {
        return lastName + " " + name;
    }

}
