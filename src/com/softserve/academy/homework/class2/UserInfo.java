package com.softserve.academy.homework.class2;

import java.util.Scanner;

public class UserInfo {
    public static void main(String[] args) {
        String name,address;
        Scanner input = new Scanner(System.in);
        System.out.println("What is your name?");
        name = input.nextLine();
        System.out.println("Where do you live, "+name+"?");
        address = input.nextLine();
        System.out.print("Name: "+name+", Address: "+address);

    }
}
