package org.algorithms.educative;

public class BinarySearch {

    public static void main(String[] args) {
        int i = binSearch(new int[]{1, 2, 4, 7, 8, 12, 15, 19, 24, 50, 69, 80, 100},-1);
        System.out.println(i);
    }

    static int binSearch(int[] a, int key) {
        if (a == null) return -1;
        int lo = 0;
        int hi = a.length;
        int mid = (lo + hi) / 2;
        while (lo <= hi) {
            int current = a[mid];
            if (current == key) return mid;
            if (current < key) lo = mid + 1;
            if (current > key) hi = mid - 1;
            mid = (lo + hi) / 2;
        }
        return -1;
    }
}
