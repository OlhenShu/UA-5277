package com.softserve.academy.homework.maksym.L5_Arrays_and_Loops;

import java.util.Arrays;

public class ReverseSortedArray {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        getReverseSorted(array);
    }

    public static int[] getReverseSorted(int[] array) {

        // КРОК №1: СТВОРЕННЯ КОПІЇ МАСИВУ (З ДОВЖИНОЮ ПЕРЕДАНОГО МАСИВУ)
        int[] copy = Arrays.copyOf(array, array.length);


        // КРОК №2: СОРТУВАННЯ КОПІЇ МАСИВУ
        Arrays.sort(copy);


        // КРОК 3: РОЗВОРОТ МАСИВУ
        for (int i = 0; i < copy.length / 2; i++) {
            int tmp = copy[i];
            copy[i] = copy[copy.length - (i + 1)];
            copy[copy.length - (i + 1)] = tmp;
        }
        return copy;

    }
}

