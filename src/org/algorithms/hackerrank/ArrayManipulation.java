package org.algorithms.hackerrank;

import java.util.Arrays;

public class ArrayManipulation {

    public static void main(String[] args) {

//        10 4
//        2 6 8
//        3 5 7
//        1 8 1
//        5 9 15

        long l = arrayManipulation(10, new int[][]{
                {2, 6, 8},
                {3, 5, 7},
                {1, 8, 1},
                {5, 9, 15}
        });

        System.out.println(l);

    }

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

        if (n < 3 || n > Math.pow(10, 7)) return -1;
        if (queries.length == 0 || queries.length > 2 * Math.pow(10, 5)) return -1;

        long[] arr = new long[n];
        Arrays.fill(arr, 0);
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int number = query[2];
            if (a < 1 || a > b || b > n) return -1;
            if (number < 0 || number > Math.pow(10, 9)) return -1;

            for (int j = a; j <= b; j++) {
                arr[j - 1] = arr[j - 1] + number;
            }
        }
        return Arrays.stream(arr).max().getAsLong();

    }

    static long arrayManipulationOptimal(int n, int[][] queries) {
        long[] arr = new long[n];
        Arrays.fill(arr, 0);

        long sum; int a, b;
        for (int[] query : queries) {
            a = query[0];
            b = query[1];
            sum = query[2];
            arr[a - 1] += sum;
            if (b < n) arr[b] -= sum;
        }

        long max=0;
        long temp=0;
        for(int i = 0; i < n; i++){
            temp += arr[i];
            if(temp > max) max = temp;
        }
        return max;
    }
}
