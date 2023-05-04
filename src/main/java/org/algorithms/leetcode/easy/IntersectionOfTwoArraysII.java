package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        Set<Integer> takenPosition = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int currentNumber : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (currentNumber == nums2[j] && !takenPosition.contains(j)) {
                    takenPosition.add(j);
                    result.add(currentNumber);
                    break;
                }
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public int[] intersectV2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }

        Map<Integer, Integer> amountOfNumbers = new HashMap<>(nums2.length);

        for (int num : nums2) {
            amountOfNumbers.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int currentNumber : nums1) {
            if (amountOfNumbers.get(currentNumber) != null && amountOfNumbers.get(currentNumber) > 0) {
                amountOfNumbers.compute(currentNumber, (k, v) -> v == null ? 0 : v - 1);
                result.add(currentNumber);
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }

    public int[] intersectV3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new ArrayList<>();

        int x = 0;
        int y = 0;

        while (x < nums1.length && y < nums2.length) {
            int a = nums1[x];
            int b = nums2[y];
            if (a == b) {
                result.add(a);
                x++;
                y++;
            } else if (a < b) {
                x++;
            } else {
                y++;
            }
        }

        int[] resultArray = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
