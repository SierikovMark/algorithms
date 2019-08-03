package org.algorithms.coursera.part1.week1.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ThreeSumQuadratic {

    static int count = 0, operations = 0;

    public static void main(String[] args) {

        // 5         0  1  2   3   4   5   6    7   8    9  10
        int[] ar = { 1, 5, 0, -5, 78, -1, 40, -30, -10, -6, 4, 17, 11, 23, -22, -102, 205, 2, 7};

        System.out.println("Array size = " + ar.length);


        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    operations++;
                    if (ar[i] + ar [j] + ar[k] == 0) {
                        count++;
                    }
                }
            }
        }

        System.out.println("Brute-force,                     count=" + count + ",  operations=" + operations);

        count = 0; operations = 0;
        for (int i = 0; i < ar.length - 2; i++) {
            s:
            for (int j = i + 1; j < ar.length - 1; j++) {
                for (int k = j + 1; k < ar.length; k++) {
                    operations++;
                    if (ar[i] + ar [j] + ar[k] == 0) {
                        count++;
                        continue s;
                    }
                }
            }
        }
        System.out.println("Brute-force with continue,       count=" + count + ",  operations=" + operations);


        Arrays.sort(ar);
        operations = 0; count = 0;
        //   5          0     1   2   3   4   5  6  7  8   9  10
        //int[] ar = { -30, -10, -6, -5, -1,  0, 1, 4, 5, 40, 78};
        for (int i = 0; i < ar.length; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                operations++;
                int value = binarySearch(-(ar[i] + ar[j]), ar, j + 1, ar.length);
                if (value > 0) {
                    count++;
                }
            }
        }
        System.out.println("Binary search for third element, count=" + count + ",  operations=" + operations);

        count = 0; operations = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < ar.length; i++) {
            map.put(ar[i], i);
        }
        for (int i = 0; i < ar.length - 2; i++) {
            for (int j = i + 1; j < ar.length - 1; j++) {
                operations++;
                if (map.containsKey(-(ar[i] + ar[j])) && map.get(-(ar[i] + ar[j])) > j) {
                    count++;
                }
            }
        }

        System.out.println("Using hashMap                    count=" + count + ",  operations=" + operations);


    }

    public static int binarySearch(int value, int[] array, int lo, int hi) {
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            operations++;
            int element = array[mid];
            if (element > value) {
                hi = mid - 1;
            } else if (element < value) {
                lo = mid + 1;
            } else {
                return mid;
            }
            mid = (lo + hi) / 2;
        }
        return -1;
    }
}
