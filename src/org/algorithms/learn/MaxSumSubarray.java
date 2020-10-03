package org.algorithms.learn;

public class MaxSumSubarray {

    public static int maxSumSubArray(int[] array, int sizeOfSubArray) {
        if (array == null || array.length < sizeOfSubArray) {
            return -1;
        }

        int max = Integer.MIN_VALUE, currentMax = 0;
        for (int i = 0; i < array.length; i++) {
            currentMax += array[i];
            if (i >= sizeOfSubArray - 1) {
                max = Math.max(max, currentMax);
                currentMax -= array[i - (sizeOfSubArray - 1)];
            }
        }
        return max;
    }

    public static int maxSumSubArrayNMultipleKVersion(int[] array, int sizeOfSubArray) {
        if (array == null || array.length < sizeOfSubArray) {
            return -1;
        }

        int left = 0, right = left + sizeOfSubArray, max = Integer.MIN_VALUE;
        while (right <= array.length) {
            int tempSum = 0;
            for (int i = left; i < right; i++) {
                tempSum += array[i];
            }
            max = Math.max(tempSum, max);
            left++;
            right = left + sizeOfSubArray;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[] {4,2,1,7,8,1,2,8,1,0}, 3));
    }

    // 7
    // 10
    // 16
    // 11
    // 11
    // 9
}
