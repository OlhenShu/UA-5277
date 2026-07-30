package com.softserve.academy.module3;

public class Util {
    public static void print(String welcomeMessage, String... messages) {
        System.out.println(welcomeMessage);
        System.out.println("--------------------");
        for (String msg : messages) {
            System.out.println(msg);
        }
    }
}

class Runner {
    public static void main(String[] args) {
        Util.print("Hello from first argument", "Hi", "Welcome", "10", "20.5", "false", "student");
    }
}
