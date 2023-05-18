package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsIntegerArray {

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Set<Integer> candidates = new HashSet<>();
        for (int num : nums) {
            candidates.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();

        backtracking(result, new ArrayList<>(), candidates, candidates.size());


        return result;
    }

    private void backtracking(List<List<Integer>> result, List<Integer> permutation, Set<Integer> candidates, int max) {
        if (permutation.size() == max) {
            result.add(permutation);
            return;
        }

        for (Integer candidate : candidates) {
            List<Integer> newPermutation = new ArrayList<>(permutation);
            Set<Integer> newCandidates = new HashSet<>(candidates);
            newPermutation.add(candidate);
            newCandidates.remove(candidate);
            backtracking(result, newPermutation, newCandidates, max);
        }
    }

    public List<List<Integer>> permuteV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        permuteRecur(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void permuteRecur(int[] nums, List<List<Integer>> result, List<Integer> currentResult, boolean[] used) {
        if (currentResult.size() == nums.length) {
            result.add(new ArrayList<>(currentResult));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            currentResult.add(nums[i]);
            used[i] = true;
            permuteRecur(nums, result, currentResult, used);
            used[i] = false;
            currentResult.remove(currentResult.size() - 1);
        }
    }
}
