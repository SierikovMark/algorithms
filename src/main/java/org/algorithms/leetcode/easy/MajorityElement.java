package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    // Boyer-Moore Voting Algorithm
    // Time complexity is O(n), space complexity is O(1)
    public static int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalStateException();
        }
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Time complexity is O(n), space complexity is O(n)
    public static int majorityElementWithHash(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                Integer integer = hash.get(num);
                hash.put(num, ++integer);
            } else {
                hash.put(num, 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int v : hash.values()) {
            if (v > max) {
                max = v;
            }
        }

        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == max) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("No Majority Element in the array");
    }


    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));
        System.out.println(majorityElement(new int[]{7, 7, 5, 7, 5, 1, 1, 7, 7}));
    }
}
