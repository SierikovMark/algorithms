package org.algorithms.leetcode.easy;

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
}
