package org.algorithms.learn;

public class SmallestSubarrayGivenSum {

    // [4,2,1,7,8,1,2,8,1,0]

    public static int smallestSubarrayGivenSum(int[] array, int targetSum) {
        if (array.length == 0) {
            return -1;
        }

        int windowStart = 0, currentSum = 0, smallestSubarraySize = Integer.MAX_VALUE;
        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            currentSum += array[windowEnd];
            while (currentSum >= targetSum) {
                currentSum -= array[windowStart];
                smallestSubarraySize = Math.min(smallestSubarraySize, windowEnd - windowStart + 1);
                windowStart++;
                if (smallestSubarraySize == 1) return smallestSubarraySize;
            }
        }
        return -1;
    }

    public static int smallestSubarrayGivenSumBruteForce(int[] array, int targetSum) {
        if (array.length == 0) {
            return -1;
        }

        int left = 0, right = 0;
        while (right < array.length) {
            int currentSum = 0;
            for (int i = left; i <= right; i++) {
                currentSum += array[i];
            }
            if (currentSum >= targetSum) {
                if (right - left == 0) {
                    return currentSum;
                } else {
                    left++;
                }
            } else {
                right++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(smallestSubarrayGivenSum(new int[] {4,2,1,7,8,1,2,8,1,0}, 1));
    }
}
