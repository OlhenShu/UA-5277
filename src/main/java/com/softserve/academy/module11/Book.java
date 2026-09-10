package com.softserve.academy.module11;

public record Book(String title, String author, int year) {

    @Override
    public String toString() {
        return "\"" + title() + "\" by " + author() + " (" + year() + ")";
    }
}