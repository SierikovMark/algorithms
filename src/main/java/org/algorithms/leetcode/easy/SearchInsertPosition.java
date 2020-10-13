package org.algorithms.leetcode.easy;

public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;

        int lo = 0, hi = nums.length - 1;
        int mid = (lo + hi) / 2;

        while (lo <= hi) {
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }
        return lo;
    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5) + " = 2");
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2) + " = 1");
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7) + " = 4");
        System.out.println(searchInsert(new int[] {1,3,5,6}, 0) + " = 0");
        System.out.println(searchInsert(new int[] {1}, 0) + " = 0");
        System.out.println(searchInsert(new int[] {1}, 2) + " = 1");
    }
}
