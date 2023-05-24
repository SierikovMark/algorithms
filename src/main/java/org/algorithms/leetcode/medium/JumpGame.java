package org.algorithms.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        Deque<Integer> jumps = new ArrayDeque<>();
        jumps.push(nums[0]);
        int baseJumpLength = 0;
        while (!jumps.isEmpty()) {
            int currentJumpLength = jumps.pop();
            if (currentJumpLength == 0) {
                if (jumps.size() > 0) {
                    int previousJumpLength = jumps.pop();
                    baseJumpLength -= previousJumpLength;
                    jumps.push(previousJumpLength - 1);

                }
                continue;
            }
            if (baseJumpLength + currentJumpLength >= nums.length - 1) {
                return true;
            }
            int nextJumpLength = nums[baseJumpLength + currentJumpLength];
            jumps.push(currentJumpLength);
            jumps.push(nextJumpLength);
            baseJumpLength += currentJumpLength;
        }

        return false;
    }

    public boolean canJumpV2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        return helper(0, nums);
    }

    private boolean helper(int index, int[] nums) {
        if (nums[index] == 0) {
            return false;
        }
        if (index + nums[index] >= nums.length) {
            return true;
        }

        int i = 1;
        while (i <= nums[index]) {
            if (helper(index + i, nums)) {
                return true;
            }
            i++;
        }

        return false;
    }

    public boolean canJumpV3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        Set<Integer> tested = new HashSet<>();

        return helperV3(0, nums, tested);
    }

    private boolean helperV3(int index, int[] nums, Set<Integer> tested) {
        if (nums[index] == 0 || tested.contains(index)) {
            return false;
        }
        if (index + nums[index] >= nums.length) {
            return true;
        }

        int i = 1;
        while (i <= nums[index]) {
            if (helperV3(index + i, nums, tested)) {
                return true;
            } else {
                tested.add(index + i);
            }
            i++;
        }

        return false;
    }

    public boolean canJumpV4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1 && nums[0] == 0) {
            return true;
        }

        int longestJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > longestJump) return false;

            longestJump = Math.max(longestJump, i + nums[i]);
        }

        return true;
    }
}
