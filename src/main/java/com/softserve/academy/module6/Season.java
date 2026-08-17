package com.softserve.academy.module6;

public class Season {
    private String seasonName;

    public static Season SUMMER = new Season("Summer");
    public static Season WINTER = new Season("Winter");
    public static Season SPRING = new Season("Spring");
    public static Season AUTUMN = new Season("Autumn");

    private Season(String seasonName) {
        this.seasonName = seasonName;
    }

    public String getSeasonName() {
        return seasonName;
    }

}
