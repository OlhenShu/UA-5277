package com.softserve.academy.module3;

import java.util.Scanner;

public class StudentDemo {
    //Scanner object to read input from the console
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Student Demo!");
        System.out.println("Creating a student using default constructor and setters:");
        Student student = new Student();
        student.setName("John");
        student.setLastName("Doe");
        student.setAge(-20);
        student.setGroup("CS101");
        //Example of using public fields (not recommended, use setters instead)
//        student.lastName = "Doe";
//        student.age = -20;
//        student.group = "CS101";
        System.out.println("Is student: " + student.isStudent());
        student.printStudentInfo();
        System.out.println("-".repeat(20));
        System.out.println("Student Info:" + "\n" + "First Name: " + student.getFirstName() + "\n" + "Last Name: " + student.getLastName() + "\n" + "Age: " + student.getAge() + "\n" + "Group: " + student.getGroup());
        System.out.println("-".repeat(20));
        //Creating a student using parameterized constructor
        Student student2 = new Student("Adam", "Brown", 18, "CS102");
        System.out.println("Is student: " + student2.isStudent());
        student2.printStudentInfo();
        System.out.println("Student Info:" + "\n" + "Full Name: " + student2.getFullName() + "\n" + "Age: " + student2.getAge() + "\n" + "Group: " + student2.getGroup());
        System.out.println(student2);
        System.out.println("-".repeat(20));

        //Creating a student using scanner
        Student student3 = new Student();
        System.out.print("Enter first name: ");
        student3.setName(scanner.nextLine());
        System.out.print("Enter last name: ");
        student3.setLastName(scanner.nextLine());
        System.out.print("Enter age: ");
        student3.setAge(scanner.nextInt());
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter group: ");
        student3.setGroup(scanner.nextLine());
        student3.printStudentInfo();
    }
}
