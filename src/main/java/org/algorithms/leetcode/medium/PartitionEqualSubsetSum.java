package org.algorithms.leetcode.medium;

public class PartitionEqualSubsetSum {

    /*
        [1, 5, 11, 5] -> sum = 22;

        2x = total sum;

        x = total sum / 2;

        reduce task -- find sub set which has sum of the element = some value (total sum / 2)

    */

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;

        long sum = 0;
        for (int num : nums) sum += num;

        if (sum % 2 == 1)
            return false;

        if (sum / 2 > Integer.MAX_VALUE) {
            throw new RuntimeException("Algorithm doesn't support such big values");
        }

        int target = (int) sum / 2;

        Boolean[][] memo = new Boolean[nums.length][target + 1];
        return backtrackMemo(nums, 0, target, memo);
    }


    private boolean backtrackMemo(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }

        if (memo[index][target] != null) {
            return memo[index][target];
        }

        int candidate = nums[index];
        memo[index][target] = backtrackMemo(nums, index + 1, target - candidate, memo) || backtrackMemo(nums, index + 1, target, memo);

        return memo[index][target];
    }


    private boolean backtrack(int[] nums, int index, int target) {
        if (target == 0) {
            return true;
        }
        if (index >= nums.length) {
            return false;
        }
        int candidate = nums[index];
        return backtrack(nums, index + 1, target - candidate) || backtrack(nums, index + 1, target);
    }



    private boolean backtrackOrigin(int[] nums, int index, int target, int currentSum) {
        if (currentSum == target) {
            return true;
        }
        if (index >= nums.length || currentSum > target) {
            return false;
        }
        int candidate = nums[index];
        return backtrackOrigin(nums, index + 1, target, currentSum + candidate) || backtrackOrigin(nums, index + 1, target, currentSum);
    }
}
