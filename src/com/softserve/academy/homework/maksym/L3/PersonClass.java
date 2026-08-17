package com.softserve.academy.homework.maksym.L3;

import java.util.Scanner;

public class PersonClass {
    static void main() {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        Person person5 = new Person();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter information for the person 1");
        person1.input(scanner);

        System.out.println("Please enter information for the person 2");
        person2.input(scanner);

//        System.out.println("Please enter information for the person 3");
//        person3.input(scanner);
//
//        System.out.println("Please enter information for the person 4");
//        person4.input(scanner);
//
//        System.out.println("Please enter information for the person 5");
//        person5.input(scanner);
        scanner.close();


        person1.output();
        person2.output();
//        person3.output();
//        person4.output();
//        person5.output();


        person2.changeName("NewName", "NewLastName");
        person2.output();

    }
}



