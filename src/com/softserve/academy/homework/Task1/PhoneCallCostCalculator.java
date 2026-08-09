package com.softserve.academy.homework.Task1;

import java.util.Scanner;

public class PhoneCallCostCalculator {
    static Scanner sc = new Scanner(System.in);

    static void main() {

        double c1;
        double c2;
        double c3;
        int t1;
        int t2;
        int t3;

        System.out.println("Cost per minute of call 1: ");
        c1 = sc.nextDouble();

        System.out.println("Duration of call 1 (min): ");
        t1 = sc.nextInt();

        System.out.println("Cost per minute of call 2: ");
        c2 = sc.nextDouble();

        System.out.println("Duration of call 2 (min): ");
        t2 = sc.nextInt();

        System.out.println("Cost per minute of call 3: ");
        c3 = sc.nextDouble();

        System.out.println("Duration of call 3 (min): ");
        t3 = sc.nextInt();

        double cost1 = c1 * t1;
        double cost2 = c2 * t2;
        double cost3 = c3 * t3;

        System.out.println("Call 1 cost: " + cost1);
        System.out.println("Call 2 cost: " + cost2);
        System.out.println("Call 3 cost: " + cost3);
        System.out.println("Total cost: " + (cost1 + cost2 + cost3));

        sc.close();

    }
}
