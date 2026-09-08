package com.softserve.academy.module10;

public class Container {
    private static int count = 0;
    private int capacity;

    public Container(int capacity) {
        this.capacity = capacity;
    }

    void printInfo() {
        System.out.println("Container capacity: " + capacity + ", Label: " + new Label("Default Label").getLabel());
    }

    public class Label {

        private String label;

        public Label(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        void print() {
            System.out.println("Container capacity: " + count + ", Label: " + label);
        }
    }
}
