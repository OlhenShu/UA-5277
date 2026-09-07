package com.softserve.academy.module8;

public record Student(String firstName, String lastName, int age) implements Comparable<Student> {
    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.age, o.age);
    }
}
