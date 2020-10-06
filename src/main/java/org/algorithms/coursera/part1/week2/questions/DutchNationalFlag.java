package org.algorithms.coursera.part1.week2.questions;

public class DutchNationalFlag {
    private static final int RED = 1;
    private static final int WHITE = 2;
    private static final int BLUE = 3;

    public static void swap(Integer[] array, int index1, int index2) {
        int tempValue = array[index1];
        array[index1] = array[index2];
        array[index2] = tempValue;
    }

    public static String color(int[] array, int index) {
        int value = array[index];
        if (value == RED) {
            return "Red";
        }
        if (value == BLUE) {
            return "Blue";
        }
        if (value == WHITE) {
            return "White";
        }
        throw new IllegalArgumentException("Unknown color " + value);
    }

    public static String color(int value) {
        if (value == RED) {
            return "Red";
        }
        if (value == BLUE) {
            return "Blue";
        }
        if (value == WHITE) {
            return "White";
        }
        throw new IllegalArgumentException("Unknown color " + value);
    }

    public static void sort(Integer[] buckets) {
        int currentIndex = 0, lowIndex = 0, higherIndex = buckets.length - 1;
        while (currentIndex <= higherIndex) {
            if (buckets[currentIndex] == 1) {
                swap(buckets, currentIndex, lowIndex);
                lowIndex++;
                currentIndex++;
            } else if (buckets[currentIndex] == 2) {
                currentIndex++;
            } else if (buckets[currentIndex] == 3) {
                swap(buckets, currentIndex, higherIndex);
                higherIndex--;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ar = { 1, 2, 2, 2, 3, 3, 3, 1, 1};

        sort(ar);

        for (Integer integer : ar) {
            System.out.println(color(integer));
        }


    }
}

