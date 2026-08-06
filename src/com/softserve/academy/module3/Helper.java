package com.softserve.academy.module3;


public class Helper {
    public static final double PI_VALUE = 3.14;
    private String info;
    private static String msg;

    static {
        msg = "Hello world!";
      //  System.out.println("Static block executed. Initial msg: " + msg);
    }


    public static void setMsg(String msg) {
        Helper.msg = msg;
    }

    public static int minValue(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void printMessage(String message) {
       // setMsg(message);
        System.out.println(msg);
        // System.out.println(info); // This will cause a compilation error because 'info' is not static
    }
}

class RunnerDemo {
    public static void main(String[] args) {
        Helper.printMessage("Hello from Helper class!");

        System.out.println(Helper.minValue(15, 35, 12));

    }
}
