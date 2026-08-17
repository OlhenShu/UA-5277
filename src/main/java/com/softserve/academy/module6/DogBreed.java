package com.softserve.academy.module6;

public enum DogBreed {
    LABRADOR_RETRIEVER("Labrador Retriever", 30.0, 15),
    GERMAN_SHEPHERD("German Shepherd", 35.0, 13),
    GOLDEN_RETRIEVER("Golden Retriever", 32.0, 14),
    BULLDOG("Bulldog", 24.0, 10),
    BEAGLE("Beagle", 10.0, 12);

    private final String breedName;
    private final double averageWeight;
    private final int averageLifespan;

    DogBreed(String breedName, double averageWeight, int averageLifespan) {
        this.breedName = breedName;
        this.averageWeight = averageWeight;
        this.averageLifespan = averageLifespan;
    }

    public String sizeCategory() {
        if (averageWeight <= 10) {
            return "Small";
        }
        if (averageWeight < 30) {
            return "Medium";
        }
        return "Large";
    }

    public static DogBreed heaviestBreed() {
        DogBreed heaviest = values()[0];
        for(DogBreed breed : values()) {
            if (breed.getAverageWeight() > heaviest.getAverageWeight()) {
                heaviest = breed;
            }
        }
        return heaviest;
    }

    public String getBreedName() {
        return breedName;
    }

    public double getAverageWeight() {
        return averageWeight;
    }

    public int getAverageLifespan() {
        return averageLifespan;
    }
}
