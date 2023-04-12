package org.algorithms.leetcode.easy;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        if (n == 0) return 0;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) result++;
            n >>= 1;
        }

        return result;

    }
}
