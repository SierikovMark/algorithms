package org.algorithms.leetcode.easy;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int current : nums) {
            if (sum < current) {
                sum = current;
            } else {
                sum += current;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
