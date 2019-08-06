package org.algorithms.coursera.part1.week2.sort;

public class Shellsort {

    public static void sort(Comparable[] a) {

        int n = a.length;
        int h = 1;

        while(h < n / 3) h = 3 * h + 1;

        while (h >= 1) {

            for (int i = 1; i < a.length; i++) {
                int j = i;
                while (less(a[j], a[j - h])) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
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
        Integer[] ar = {10, 1, 3, 1, 2, 7};

        Selection.sort(ar);

        for (Comparable c : ar) {
            System.out.println(c);
        }

    }

}