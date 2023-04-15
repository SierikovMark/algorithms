package org.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for (int num : nums) {
            if (cache.contains(num)) {
                return true;
            }
            cache.add(num);
        }
        return false;
    }

    public boolean containsDuplicateV2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
