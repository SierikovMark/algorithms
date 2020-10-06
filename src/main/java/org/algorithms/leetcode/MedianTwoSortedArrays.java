package org.algorithms.leetcode;

public class MedianTwoSortedArrays {

    public static double findMedianSortedArraysNoExtraArray(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;

        int middle = length / 2;
        int x = 0, y = 0, i = 0;
        int lastValue = Math.min(nums1.length, nums2.length);
        while (x < nums1.length || y < nums2.length) {

            if (i == middle) {
                int nextValue;
                if (y >= nums2.length || x < nums1.length && nums1[x] <= nums2[y]) {
                    nextValue = nums1[x];
                } else {
                    nextValue = nums2[y];
                }
                if (length % 2 == 0) {
                    return (double) (lastValue + nextValue) / 2;
                } else {
                    return nextValue;
                }
            }

            if (y >= nums2.length || x < nums1.length && nums1[x] <= nums2[y]) {
                lastValue = nums1[x];
                x++;
            } else {
                lastValue = nums2[y];
                y++;
            }
            i++;
        }
       throw new IllegalStateException();
    }

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
        System.out.println(findMedianSortedArraysNoExtraArray(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArraysNoExtraArray(new int[]{1,2}, new int[]{3,4}));
    }
}
