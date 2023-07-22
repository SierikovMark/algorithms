package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    /*
    * backtracking/recursion
    * Time complexity O(n * 2^n)
    * Space complexity O(2^n)
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, List<Integer> subset, int index) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // Pick
        subset.add(nums[index]);
        backtrack(result, nums, subset, index + 1);
        subset.remove(subset.size() - 1);

        // Not pick
        backtrack(result, nums, subset, index + 1);
    }


    /*
     * iterative approach
     * Time complexity O(n * 2^n)
     * Space complexity O(2^n)
     */
    public List<List<Integer>> subsetsV2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for (int num : nums) {
            for (int j = 0, size = result.size(); j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }
}
