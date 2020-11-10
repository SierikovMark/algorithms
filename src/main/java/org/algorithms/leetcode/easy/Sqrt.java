package org.algorithms.leetcode.easy;

public class Sqrt {

    //TODO: I saw solution with bit-wise operations. Try to apply after understanding how it works.

    public static int mySqrtBinarySearch(int x) {
        if (x <= 1) return x;
        int lo = 0;
        int hi = x;
        int mid = (lo + hi) / 2;

        while (lo < hi) {
            if (mid <= x / mid && (mid + 1) > x / (mid + 1) ) {
                return mid;
            }
            if (mid < x / mid) {
                lo = mid + 1;
            }
            if (mid > x / mid) {
                hi = mid;
            }
            mid = (hi + lo) / 2;
        }
        return -1;
    }

    public static int mySqrtBruteForce(int x) {
        if (x == 0) return 0;
        int result = 1;
        while (result * result < x && (result + 1) * (result + 1) <= x) {
            result++;
        }
        return result;
    }

    // Not working solution currently. Want to implement manual calculation algorithm.
    public static int mySqrtFirstTry(int x) {
        String number = String.valueOf(x);
        boolean evenLeading = number.length() % 2 == 1;
        StringBuilder result = new StringBuilder();
        if (evenLeading) {
            result.append(calculateSqrt(Character.getNumericValue(number.charAt(0))));
        }
        int i = evenLeading ? 1 : 0;
        for (; i < number.length() - 1; i+=2) {
            result.append(calculateSqrt(Integer.parseInt(number.substring(i, i + 2))));
        }

        return Integer.parseInt(result.toString());
    }

    private static int calculateSqrt(int num) {
        if (num < 1) return 0;
        if (num < 4) return 1;
        if (num < 9) return 2;
        if (num < 16) return 3;
        if (num < 25) return 4;
        if (num < 36) return 5;
        if (num < 49) return 6;
        if (num < 64) return 7;
        if (num < 81) return 8;
        if (num < 100) return 9;
        throw new RuntimeException("Illegal value: " + num);
    }


    public static void main(String[] args) {
        System.out.println(mySqrtBinarySearch(4));
        System.out.println(mySqrtBinarySearch(101));
    }
}
