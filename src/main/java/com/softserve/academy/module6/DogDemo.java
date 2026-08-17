package com.softserve.academy.module6;

import java.util.Scanner;

public class DogDemo {

    static DogBreed readBread(Scanner scanner) {
        System.out.println("Enter dog breed: ");
        String breed = scanner.nextLine().trim().toUpperCase();
        return DogBreed.valueOf(breed);
    }

    static String describe(DogBreed breed) {
        return breed + ": " + breed.sizeCategory()
                + ", " + breed.getAverageLifespan() + " years lifespan"
                + ", " + breed.getAverageWeight() + " weights.";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DogBreed dog = DogBreed.LABRADOR_RETRIEVER;
        DogBreed breed = readBread(scanner);
        System.out.println(describe(breed));

        DogBreed dogBreed = DogBreed.BEAGLE;
        System.out.println("Dog breed: " + dogBreed.sizeCategory());

        scanner.close();
    }
}
