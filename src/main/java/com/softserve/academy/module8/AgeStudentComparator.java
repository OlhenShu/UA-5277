package com.softserve.academy.module8;

import java.util.Comparator;

public class AgeStudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s2.age(), s1.age());
    }
}
