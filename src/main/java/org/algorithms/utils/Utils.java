package org.algorithms.utils;

public class Utils {

    public static void printIntArray(int[] arr, int index) {
        if (index >= arr.length) throw new IllegalArgumentException("Array length less then required index");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]);
            if (i != index - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
