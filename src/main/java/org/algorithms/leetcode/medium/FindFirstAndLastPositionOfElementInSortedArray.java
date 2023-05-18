package org.algorithms.leetcode.medium;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

            if (target == nums[mid]) index = mid;
        }

        return index;
    }


    private int findLast(int[] nums, int target) {
        int index = -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

            if (target == nums[mid]) index = mid;
        }

        return index;
    }
}
