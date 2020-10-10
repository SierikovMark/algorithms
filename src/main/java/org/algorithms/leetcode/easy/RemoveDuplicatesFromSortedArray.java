package org.algorithms.leetcode.easy;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;

        int length = nums.length;
        if (length == 0 || length == 1) return length;

        int i = 0, j = 1;
        while (j < length) {
            if (nums[i] < nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] testArr1 = new int[] {0,0,1,1,1,2,2,3,3,4};
        print(testArr1, removeDuplicates(testArr1));

        int[] testArr2 = new int[] {1,1,2};
        print(testArr2, removeDuplicates(testArr2));

        int[] testArr3 = new int[] {1,2,3};
        print(testArr3, removeDuplicates(testArr3));
    }

    private static void print(int[] testArr1, int i) {
        for (int j = 0; j < i; j++) {
            System.out.print(testArr1[j] + " ");
        }
        System.out.println();
    }
}
