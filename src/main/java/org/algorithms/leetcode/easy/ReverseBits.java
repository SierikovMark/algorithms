package org.algorithms.leetcode.easy;

public class ReverseBits {

    public int reverseBits(int n) {
        if (n == 0) return 0;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;
            int lastBit = n & 1;
            if (lastBit == 1) {
                result++;
            }
            n >>= 1;
        }
        return result;
    }
}
