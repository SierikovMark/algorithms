package org.algorithms.coursera.part1.week3;

import org.algorithms.coursera.part1.week2.sort.Shellsort;

public class Mergesort {

    public static void sort(Comparable[] array) {

        Comparable[] tempArray1 = new Comparable[array.length / 2];
        for (int i = 0; i < array.length / 2; i++) {
            tempArray1[i] = array[i];
        }

        Comparable[] tempArray2 = new Comparable[array.length - array.length / 2];
        for (int i = array.length / 2; i < array.length; i++) {
            tempArray2[i - array.length / 2] = array[i];
        }

        Shellsort.sort(tempArray1);
        Shellsort.sort(tempArray2);

        for (int i = 0; i < array.length / 2; i++) {
            array[i] = tempArray1[i];
        }

        for (int i = array.length / 2; i < array.length; i++) {
            array[i] = tempArray2[i - array.length / 2];
        }


        Comparable[] tempArray = new Comparable[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }

        int i = 0, j = array.length / 2;

        for (int k = 0; k < array.length; k++) {
            if (i >= array.length / 2) {
                array[k] = tempArray[j];
                j++;
                continue;
            }
            if (j >= array.length - 1) {
                array[k] = tempArray[j];
                i++;
                continue;
            }
            Comparable comparable1 = tempArray[i];
            Comparable comparable2 = tempArray[j];
            if (comparable1.compareTo(comparable2) <= 0) {
                array[k] = comparable1;
                i++;
            } else {
                array[k] = comparable2;
                j++;
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int position, int minPosition) {
        Comparable temp = a[position];
        a[position] = a[minPosition];
        a[minPosition] = temp;
    }


    public static void main(String[] args) {
        Integer[] ar = {7,3,2,5,7,8,9,1,3,7};
        sort(ar);

        for (Integer integer : ar) {
            System.out.println(integer);
        }
    }
}
