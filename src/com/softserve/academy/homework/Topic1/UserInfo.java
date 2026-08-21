package com.softserve.academy.homework.Topic1;

import java.util.Scanner;

public class UserInfo {
    static Scanner sc = new Scanner(System.in);

    static void main() {

        String name;
        String address;

        System.out.println("What is your name? ");
        name = sc.nextLine();

        System.out.println("Where do you live, " + name + "? ");
        address = sc.nextLine();

        System.out.println("Name: " + name + ", Address: " + address);

        sc.close();

    }
}
