package org.algorithms.coursera.part1.week2.sort;

public class Insertion {

    public static void sort(Comparable[] ar) {

        for (int i = 1; i < ar.length; i++) {
            int j = i;
            while(j > 0 && less(ar[j], ar[j - 1])) {
                exch(ar, j, j - 1);
                j--;
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
        Integer[] ar = {10, 1, 3, 1, 2, 7};

        Selection.sort(ar);

        for (Comparable c : ar) {
            System.out.println(c);
        }

    }

}