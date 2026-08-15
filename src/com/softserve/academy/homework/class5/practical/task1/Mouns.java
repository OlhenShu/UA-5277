package com.softserve.academy.homework.class5.practical.task1;

import java.util.Scanner;

public class Mouns {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] mounts = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.print("Enter the mount number: ");
        int inputNumber = input.nextInt();
        if (inputNumber > 12 || inputNumber < 0) {
            System.out.println("Invalid input");
        } else {
            System.out.println("Number of days in a month: " + mounts[inputNumber - 1]);
        }
    }
}
