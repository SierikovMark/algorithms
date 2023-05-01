package org.algorithms.leetcode.easy;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int headIndex = 0;
        int tailIndex = nums.length - 1;

        int[] result = new int[nums.length];

        for (int num : nums) {
            if (num != 0) {
                result[headIndex++] = num;
            } else {
                result[tailIndex--] = 0;
            }
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = result[i];
//        }
    }

    public void moveZeroesV2(int[] nums) {
        int amountOfZeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                amountOfZeros++;
            } else if (amountOfZeros > 0) {
                nums[i - amountOfZeros] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
