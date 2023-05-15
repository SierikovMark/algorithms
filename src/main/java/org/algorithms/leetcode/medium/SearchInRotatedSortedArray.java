package org.algorithms.leetcode.medium;

public class SearchInRotatedSortedArray {


    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int searchV2(int[] nums, int target) {
        int n = nums.length - 1;

        int lo = 0; int hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        int start = lo;
        lo = 0;
        hi = n;

        if (target >= nums[start] && target <= nums[hi]) {
            lo = start;
        } else {
            hi = start;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2 ;
            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }


    public int searchV3(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length - 1;

        int left = 0;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
//             0 1 2 3 4 5 6 7
//            {4,5,6,7,8,1,2,3}, 8

//            [3, 1] 1
//            [9, 4, 5, 6, 7] 1


            if (nums[mid] >= nums[left]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= nums[right] && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }
}
