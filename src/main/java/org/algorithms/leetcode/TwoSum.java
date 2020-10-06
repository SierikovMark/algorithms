package org.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

class TwoSum {

    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSum2N(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int desiredValue = target - nums[i];
            Integer index = hash.get(desiredValue);
            if (index != null && index != i) {
                return new int[]{i, index};
            }
        }
        return new int[]{};
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int desiredValue = target - nums[i];
            Integer index = hash.get(desiredValue);
            if (index != null && index != i) {
                return new int[]{index, i};
            } else {
                hash.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
