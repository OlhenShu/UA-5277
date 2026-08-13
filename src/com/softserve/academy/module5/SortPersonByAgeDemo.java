package com.softserve.academy.module5;

import java.util.Arrays;

public class SortPersonByAgeDemo {
    public static void main(String[] args) {
        Person[] peoples = {
                new Person("Alice", 30),
                new Person("David", 20),
                new Person("Bob", 25),
                new Person("Charlie", 35),
        };

        System.out.println("Original array:" + Arrays.toString(peoples));

        // Sort the array using bubble sort based on age
        for (int i = 0; i < peoples.length - 1; i++) {
            for (int j = 0; j < peoples.length - 1 - i; j++) {
                if (peoples[j].age > peoples[j + 1].age) {
                    // Swap peoples[j] and peoples[j + 1]
                    Person temp = peoples[j];
                    peoples[j] = peoples[j + 1];
                    peoples[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array by age:");
        for (Person person : peoples) {
            System.out.println(person);
        }

        //sort by name bubble sort
        for (int i = 0; i < peoples.length - 1; i++) {
            for (int j = 0; j < peoples.length - 1 - i; j++) {
                if (peoples[j].name.compareTo(peoples[j + 1].name) > 0) {
                    // Swap peoples[j] and peoples[j + 1]
                    Person temp = peoples[j];
                    peoples[j] = peoples[j + 1];
                    peoples[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array by name:");
        for (Person person : peoples) {
            System.out.println(person);
        }
    }
}
