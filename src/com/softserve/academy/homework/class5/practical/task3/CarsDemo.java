package com.softserve.academy.homework.class5.practical.task3;

import java.util.Scanner;

public class CarsDemo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Cars car1 = new Cars("Sedan", 1.6, 2016);
        Cars car2 = new Cars("Hatchback", 2.4, 2019);
        Cars car3 = new Cars("Crossover", 3.0, 2026);
        Cars car4 = new Cars("Coupe", 1.4, 2016);

        Cars[] listCars = {car1, car2, car3, car4};
        System.out.println("Enter year of cars: ");
        int year = input.nextInt();
        boolean flag = false;
        for (int i = 0; i < listCars.length; i++) {
            if (year == listCars[i].getYearProduction()) {
                System.out.println(listCars[i].toString());
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("There are no cars from this year");
        }

        System.out.println("-".repeat(20));
        System.out.println("All cars sorted by production year ");
        Cars[] copyListCars = listCars.clone();
        for (int i = 0; i < copyListCars.length - 1; i++) {
            for (int j = 0; j < copyListCars.length - 1 - i; j++) {
                if (copyListCars[j].getYearProduction() > copyListCars[j + 1].getYearProduction()) {
                    Cars temp = copyListCars[j];
                    copyListCars[j] = copyListCars[j + 1];
                    copyListCars[j + 1] = temp;
                }
            }
        }
        for (Cars car : copyListCars) {
            System.out.println(car.toString());
        }
    }
}
