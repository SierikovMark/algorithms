package org.algorithms.leetcode;

public class MedianTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            if (y >= nums2.length || x < nums1.length && nums1[x] <= nums2[y]) {
                nums[i] = nums1[x];
                x++;
            } else {
                nums[i] = nums2[y];
                y++;
            }
        }
        int median;
        if (nums.length % 2 == 0) {
            median =  nums.length / 2 - 1;
            if (nums.length == 2) median = 0;
            return (double) (nums[median] + nums[median + 1]) / 2;
        } else {
            median =  nums.length / 2 + 1;
            return nums[median];
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));

    }
}
