package org.algorithms.leetcode.easy;

import java.util.Arrays;

public class TwoSumII {

    // Optimised solution
    // Time complexity is O(n), space complexity is O(1)
    public static int[] twoSum(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;
        while (lo < hi) {
            if (numbers[lo] + numbers[hi] == target) {
                return new int[]{lo + 1, hi + 1};
            } else if (numbers[lo] + numbers[hi] < target) {
                lo++;
            } else {
                hi--;
            }
        }
        return new int[]{-1};
    }

    // Brute Force solution
    // Time complexity is O(n^2), space complexity O(1)
    public static int[] twoSumBruteForce(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return new int[]{-1};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200)));
    }
}
