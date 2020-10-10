package org.algorithms.leetcode.easy;

import static org.algorithms.utils.Utils.printIntArray;

public class RemoveElementFromArray {

    public static int removeElement(int[] nums, int val) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;

        int i = 0, n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[--n];
            } else {
                i++;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        if (nums == null) return -1;
        if (nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] testArr1 = new int[] {0,0,1,1,1,2,2,3,3,4};
        printIntArray(testArr1, removeElement(testArr1, 0));

        int[] testArr2 = new int[] {1,1,2};
        printIntArray(testArr2, removeElement(testArr2, 1));

        int[] testArr3 = new int[] {1,2,3};
        printIntArray(testArr3, removeElement(testArr3, 3));

        int[] testArr4 = new int[] {3,2,2,3};
        printIntArray(testArr4, removeElement(testArr4, 3));
    }
}
