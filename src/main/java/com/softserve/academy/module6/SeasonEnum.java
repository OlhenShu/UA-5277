package com.softserve.academy.module6;

public enum SeasonEnum {
    SUMMER,
    WINTER,
    SPRING,
    AUTUMN
}

class App {
    public static void main(String[] args) {
        SeasonEnum season = SeasonEnum.WINTER;
        System.out.println("Season name: " + season);
        String seasonName = "WINTER";
        season = SeasonEnum.valueOf(seasonName);
        System.out.println("Season name: " + season);

        for (SeasonEnum s : SeasonEnum.values()) {
            System.out.println("Season: " + s);
            System.out.println("Ordinal: " + s.ordinal());
        }
    }
}
