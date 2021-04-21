package org.algorithms.other;

public class Sqrt {
    private static int totalAmountOfOperationForBinarySearch = 0;
    private static int totalAmountOfOperationForMultiplication = 0;

    public static int sqrt(int n) {
        for (int i = 1; i * i <= n; i++) {
            totalAmountOfOperationForMultiplication++;
            if (i * i == n) {
                return i;
            }
        }
        return -1;
    }

    public static long sqrtBinarySearch(int n) {
        return helper(n, 1, n);
    }

    private static long helper(int n, long min, long max) {
        totalAmountOfOperationForBinarySearch++;
        if (min > max) {
            return -1;
        }
        long guess = (max + min) / 2;
        long product = guess * guess;
        if (product == n) {
            return guess;
        } else if (product < n) {
            return helper(n, guess + 1, max);
        } else {
            return helper(n, min, guess - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(sqrtBinarySearch(1000000));
        System.out.println(totalAmountOfOperationForBinarySearch);
        System.out.println(sqrt(1000000));
        System.out.println(totalAmountOfOperationForMultiplication);
    }
}
