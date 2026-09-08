package com.softserve.academy.module8;

import java.util.Arrays;
import java.util.Comparator;

public class StudentDemo {

    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe", 20);
        Student student2 = new Student("Jane", "Smith", 17);
        Student stud3 = new Student("John", "Doe", 21);
        Student stud4 = new Student("Alice", "Brown", 18);


        Student[] students = {student1, student2, stud3, stud4};

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age(), s2.age());
            }
        });

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.firstName().compareTo(s2.firstName());
            }
        });


        Arrays.sort(students, (s2, s1) -> Integer.compare(s2.age(), s1.age()));
        for (Student student : students) {
            System.out.println(student);
        }

//        for (Student student : students) {
//            System.out.println(student);
//        }
//        System.out.println("After sorting:");
//
//        Arrays.sort(students, new FullNameAndAgeStudentComparator());
//
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        Arrays.sort(students, new AgeStudentComparator());
//        System.out.println("After sorting by age:");
//        for (Student student : students) {
//            System.out.println(student);
//        }
//        Arrays.sort(students, new FullNameComparator());
//        System.out.println("After sorting by full name:");
//        for (Student student : students) {
//            System.out.println(student);
//        }
    }
}
