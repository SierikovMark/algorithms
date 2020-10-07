package org.algorithms.leetcode;

public class MedianTwoSortedArrays {

    public static double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArraysBinarySearch(nums2, nums1);

        int length = nums1.length + nums2.length;
        int lo = 0, hi = nums1.length - 1;
        int partitionFirst = (lo + hi) / 2;
        int partitionSecond = (length + 1) / 2 - partitionFirst;

        while (partitionFirst >= -1 && partitionFirst <= nums1.length) {
            int firstLeft = partitionFirst - 1 >=0 && partitionFirst - 1 < nums1.length ? nums1[partitionFirst - 1] : Integer.MIN_VALUE;
            int secondRight = partitionSecond >=0 && partitionSecond < nums2.length ? nums2[partitionSecond] : Integer.MAX_VALUE;

            int secondLeft = partitionSecond - 1 >=0 && partitionSecond - 1 < nums2.length ? nums2[partitionSecond - 1] : Integer.MIN_VALUE;
            int firstRight = partitionFirst >=0 && partitionFirst < nums1.length ? nums1[partitionFirst] : Integer.MAX_VALUE;
            if (firstLeft <= secondRight && secondLeft <= firstRight) {
                if (length % 2 == 0) {
                    int maxInFirstHalf = Math.max(firstLeft, secondLeft);
                    int minInSecondHalf = Math.min(firstRight, secondRight);
                    return (double) (maxInFirstHalf + minInSecondHalf) / 2;
                } else {
                    return Math.max(firstLeft, secondLeft);
                }
            } else if (firstLeft > secondRight) {
                hi = partitionFirst - 1;
            } else {
                lo = partitionFirst + 1;
            }
            partitionFirst = (lo + hi + 1) / 2;
            partitionSecond = (length + 1) / 2 - partitionFirst;
        }
        throw new IllegalStateException();
    }

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

    // 1 2 | 7 8 9 - nums1 partitionFirst = 2
    // 4 5 6 | 7 8 - nums2 partitionSecond =
    // 1 2 4 5 6 7 7 8 8 9

    // -inf | +inf - nums1 - positionFirst = 0
    // 1 | +inf - nums2 - positionSecond = 1
    public static void main(String[] args) {
        System.out.println(findMedianSortedArraysBinarySearch(new int[]{1,2,7,8,9}, new int[]{4,5,6,7,8}) + " - 6,5");
        System.out.println(findMedianSortedArraysBinarySearch(new int[]{1,3}, new int[]{2}) + " - 2.0");
        System.out.println(findMedianSortedArraysBinarySearch(new int[]{1,2}, new int[]{3,4}) + " - 2.5");
        System.out.println(findMedianSortedArraysBinarySearch(new int[]{}, new int[]{1}) + " - 1.0");
    }
}

// 1 1 2 3 4 4 5 6 7 7 8 9 10 10 11 11 12 13 14 15 15 27 50 55 100 120 122 140 150 200

// 1 4 7 10 11 15 27 | 50  55 100 120 122 140 150 200 = 15, positionFirst = 7
// 1 2 3  4  5  6  7    8 | 9  10  11  12  13  14  15  = 15, positionSecond = (15 + 15 + 1) / 2 - 7 = 8
//                                                             27 < 9 = false

// 1 4 7 10 11 15 | 27 50 55  100 120 122 140 150 200 = 15, positionFirst = 6
// 1 2 3  4  5  6    7  8  9 | 10  11  12  13  14  15  = 15, positionSecond = (15 + 15 + 1) / 2 - 6 = 9
//                                                              15 < 10 = false

// 1 4 7 10 11 | 15 27 50 55  100  120 122 140 150 200 = 15, positionFirst = 5
// 1 2 3  4  5    6  7  8  9   10 | 11  12  13  14  15  = 15, positionSecond = (15 + 15 + 1) / 2 - 5 = 10
