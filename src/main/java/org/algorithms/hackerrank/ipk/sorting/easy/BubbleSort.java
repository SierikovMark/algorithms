package org.algorithms.hackerrank.ipk.sorting.easy;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    public static void countSwaps(List<Integer> a) {
        // Write your code here
        int swapCount = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = 0; j < a.size() - 1; j++) {
                if (a.get(j) > a.get(j + 1)) {
                    swap(a, j);
                    swapCount++;
                }
            }
        }
        System.out.printf("Array is sorted in %d swaps.\n", swapCount);
        System.out.printf("First Element: %d\n", a.get(0));
        System.out.printf("Last Element: %d\n", a.get(a.size() - 1));
    }

    private static void swap(List<Integer> a, int index) {
        int tmp = a.get(index);
        a.set(index, a.get(index + 1));
        a.set(index + 1, tmp);
    }


    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(3);
        ints.add(2);
        ints.add(1);
        countSwaps(ints);
    }
}
