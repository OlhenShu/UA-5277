package com.softserve.academy.module3;

public class User {
    String role;

    {
        role = "user";
        System.out.println("Instance block executed. Role: " + role);
    }

    User(){
        System.out.println("Constructor executed");
    }

    public static void main(String[] args) {
        User user = new User();
        System.out.println("User role: " + user.role);

        User anotherUser = new User();
        System.out.println("Another user role: " + anotherUser.role);
    }
}
