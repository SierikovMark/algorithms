package org.algorithms.leetcode.easy;

import org.algorithms.utils.Utils;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        verifyInput(nums1, m, n);

        int i = m - 1; int j = n - 1;

        int currentIndex = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[currentIndex--] = nums1[i--];
            } else {
                nums1[currentIndex--] = nums2[j--];
            }
        }

        while (j >= 0) {
            nums1[currentIndex--] = nums2[j--];
        }
    }

    public static void mergeFirstImplementation(int[] nums1, int m, int[] nums2, int n) {
        verifyInput(nums1, m, n);

        int i = 0; int x = 0; int y = 0;

        int[] result  = new int[nums1.length];

        while (i < nums1.length) {
            if (y >= n || nums1[x] <= nums2[y] && x < m) {
                result[i] = nums1[x++];
            } else {
                result[i] = nums2[y++];
            }
            i++;
        }

        for(i = 0; i < result.length; i++) {
            nums1[i] = result[i];
        }
    }

    private static void verifyInput(int[] nums1, int m, int n) {
        if (nums1.length != m + n) {
            throw new IllegalArgumentException("Array nums1 doesn't have enough space");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        merge(nums1, 1, new int[] {0}, 0);
        Utils.printIntArray(nums1);
    }
}
