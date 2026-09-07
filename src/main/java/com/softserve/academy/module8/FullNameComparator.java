package com.softserve.academy.module8;

import java.util.Comparator;

public class FullNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        String fullName1 = s1.firstName() + " " + s1.lastName();
        String fullName2 = s2.firstName() + " " + s2.lastName();
        return fullName1.compareTo(fullName2);
    }
}
