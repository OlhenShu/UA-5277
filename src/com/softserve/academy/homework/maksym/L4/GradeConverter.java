package com.softserve.academy.homework.maksym.L4;

public class GradeConverter {
    public static String getLetterGrade(int score) {
        String grade;
        if (score < 0 || score > 100)
            return "Invalid score. Please enter a value from 0 to 100.";
        return switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
}
