package org.algorithms.leetcode.easy;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int expectedSum = 0;
        for (int i = 0; i <= nums.length; i++) {
            expectedSum += i;
        }

        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    public int missingNumberV2(int[] nums) {
        int expectedXor = 0;
        for (int i = 0; i <= nums.length; i++) {
            expectedXor ^= i;
        }

        int actualXor = 0;
        for (int num : nums) {
            actualXor ^= num;
        }

//        We can just combine all together in a single iteration
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            result ^= i + 1;
//            result ^= nums[i];
//        }

        return expectedXor ^ actualXor;
    }

    public int missingNumberV3(int[] nums) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

}
