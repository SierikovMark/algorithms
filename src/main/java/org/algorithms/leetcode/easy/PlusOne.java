package org.algorithms.leetcode.easy;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
            i--;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] x = plusOne(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(x));
        x = plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(x));
        x = plusOne(new int[]{9});
        System.out.println(Arrays.toString(x));
        x = plusOne(new int[]{0});
        System.out.println(Arrays.toString(x));
    }
}
