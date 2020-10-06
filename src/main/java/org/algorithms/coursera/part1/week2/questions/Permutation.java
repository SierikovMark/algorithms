package org.algorithms.coursera.part1.week2.questions;

import org.algorithms.coursera.part1.week2.sort.Shellsort;

public class Permutation {

    public static boolean isPermutation(Integer[] firstSet, Integer[] secondSet) {
        if (firstSet.length != secondSet.length) return false;

        Shellsort.sort(firstSet);
        Shellsort.sort(secondSet);

        for (int i = 0; i < firstSet.length; i++) {
            if (!firstSet[i].equals(secondSet[i])) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[2];
        a[0] = 1;
        a[1] = 2;
        Integer[] b = new Integer[2];
        b[0] = 1;
        b[1] = 2;
        System.out.println(isPermutation(a, b));

        b[0] = 1;
        b[1] = 3;
        System.out.println(isPermutation(a, b));

    }


}
