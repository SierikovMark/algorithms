package org.algorithms.leetcode.medium;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == 0) {
            return 0;
        }
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean positive = (dividend > 0) == (divisor > 0);

        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }

        int result = 0;

        while (dividend - divisor >= 0) {
            int modCount = 1;
            while (dividend - (divisor * modCount * 2) >= 0) { // 3 << 2
                modCount *= 2;
            }

            result += modCount;

            dividend -= divisor * modCount;
        }

        return positive ? result : -result;
    }

    public int divideV2(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == 0) {
            return 0;
        }
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean positive = (dividend > 0) == (divisor > 0);

        if (dividend < 0) {
            dividend = -dividend;
        }
        if (divisor < 0) {
            divisor = -divisor;
        }

        int result = 0;

        while (dividend - divisor >= 0) {
            int modCount = 0;
            while (dividend - (divisor << modCount << 1) >= 0) { // 3 << 2
                modCount++;
            }

            result += 1 << modCount;

            dividend -= divisor << modCount;
        }

        return positive ? result : -result;
    }

    // Classic binary division
    public int divideV3(int dividend, int divisor) {
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        if (dividend == 0) {
            return 0;
        }
        if (Integer.MIN_VALUE == dividend && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean positive = (dividend > 0) == (divisor > 0);

        long dd = dividend < 0 ? 0L - dividend : dividend;
        long dr = divisor < 0 ? 0L - divisor : divisor;

        long result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            long dividendCandidate = dd >> i;
            if (dividendCandidate < dr) {
                continue;
            }
            long reminder = dd & ((1L << i) - 1L);
            dd = ((dividendCandidate - dr) << i) + reminder;
            result++;
        }

        if (result > Integer.MAX_VALUE && positive) {
            return Integer.MAX_VALUE;
        }

        return (int) (positive ? result : -result);
    }

}
