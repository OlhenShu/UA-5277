package com.softserve.academy.module4;

import com.softserve.academy.module3.Student;

public class RelationalOperators {
    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//
//        // Greater than
//        boolean isGreaterThan = a > b;
//        System.out.println(a + " > " + b + ": " + isGreaterThan);
//
//        // Less than
//        boolean isLessThan = a < b;
//        System.out.println(a + " < " + b + ": " + isLessThan);
//
//        // Greater than or equal to
//        boolean isGreaterThanOrEqualTo = a >= b;
//        System.out.println(a + " >= " + b + ": " + isGreaterThanOrEqualTo);
//
//        // Less than or equal to
//        boolean isLessThanOrEqualTo = a <= b;
//        System.out.println(a + " <= " + b + ": " + isLessThanOrEqualTo);
//
//        // Equal to
//        boolean isEqualTo = a == b;
//        System.out.println(a + " == " + b + ": " + isEqualTo);
//
//        // Not equal to
//        boolean isNotEqualTo = a != b;
//        System.out.println(a + " != " + b + ": " + isNotEqualTo);
//
//        String str1 = "Hello";
//        String str2 = "World";
//        String str3 = "Hello";
//
//        System.out.println("str1 == str2: " + (str1 == str2)); // false
//        System.out.println("str1 == str3: " + (str1 == str3)); // true

        Student student1 = new Student("John", "Brown", "201");
        Student student2 = new Student("John", "Brown", "201");
        System.out.println("student1 == student2: " + (student1 == student2)); // false
        System.out.println("student1.equals(student2): " + student1.equals(student2));
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

    }
}
