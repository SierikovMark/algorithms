package org.algorithms.coursera.part1.week2.sort;

public class Selection {

    public static void sort(Comparable[] a) {

        for (int i = 0; i < a.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (less(a[j], a[minIndex])) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exch(a, i, minIndex);
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
        Integer[] ar = {3, 1, 2, 7};

        Selection.sort(ar);

        for (Comparable c : ar) {
            System.out.println(c);
        }

    }

}
