package com.softserve.academy.module8;

import java.util.Comparator;

public class FullNameAndAgeStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        int lastNameComparison = s1.lastName().compareTo(s2.lastName());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }
        int firstNameComparison = s1.firstName().compareTo(s2.firstName());
        if (firstNameComparison != 0) {
            return firstNameComparison;
        }
        return Integer.compare(s1.age(), s2.age());
    }
}
