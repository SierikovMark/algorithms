package org.algorithms.coursera.part1.week3;

import org.algorithms.coursera.part1.week2.sort.Shellsort;

public class Mergesort {

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(aux, a, lo, mid);
        sort(aux, a, mid + 1, hi);
        if (less(aux[mid], aux[mid + 1])) return;
        merge(a, aux, lo, mid, hi);
    }

    public static void sortCoursera(Comparable[] a) {
        Comparable[] auxiliary = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            auxiliary[i] = a[i];
        }
        sort(a, auxiliary, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid + 1, hi);

        int i = lo, j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        if (a.length < 2) return true;

         for (int i = lo + 1; i < hi; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }

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



    public static void sortBottomUp(Comparable[] a) {
        Comparable[] auxiliary = new Comparable[a.length];
        for (int i = 0; i < a.length; i++) {
            auxiliary[i] = a[i];

        }
        sortBottomUp(a, auxiliary);
    }

    private static void sortBottomUp(Comparable[] a, Comparable[] aux) {
        for (int sz = 1; sz < a.length; sz += sz) {
            for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));

            }
            System.arraycopy(a, 0, aux, 0, a.length);
        }
    }


    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        Integer[] ar = {7,3,2,5,7,8,9,1,3,7};
        sortBottomUp(ar);

        for (Integer integer : ar) {
            System.out.println(integer);
        }
    }
}
