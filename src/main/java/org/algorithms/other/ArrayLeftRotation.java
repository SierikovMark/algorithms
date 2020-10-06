package org.algorithms.other;

public class ArrayLeftRotation {

    public static void main(String[] args) {

        int[] ar = {1,2,3,4,5};
        int[] x = rotLeft(ar, 2);
        for (int i : x) {
            System.out.print(i + " ");
        }
    }

    public static int[] rotLeft(int[] a, int d) {
        int[] newArray = new int[a.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a[getIndex(i, a.length, d)];
        }
        return newArray;
    }

    private static int getIndex(int i, int length, int d) {
        int index = i + d;
        if (index < length) return index;
        else return (index - length);
    }
}
