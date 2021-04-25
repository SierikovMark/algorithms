package org.algorithms.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    // Based on math 2 * (a + b) - (a + a + b) = b
     public int singleNumber3(int[] nums) {
         Set<Integer> setOfNums = new HashSet();
         int sumOfSet = 0, sumOfNums = 0;
         for (int num : nums) {
             if (!setOfNums.contains(num)) {
                 setOfNums.add(num);
                 sumOfSet += num;
             }
             sumOfNums += num;
         }
         return 2 * sumOfSet - sumOfNums;
     }

    public static int singleNumber2(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        if (nums[length - 1] != nums[length - 2]) {
            return nums[length - 1];
        }
        throw new RuntimeException("All nums have pair");
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> hash = new HashMap<>();
        for(int num : nums) {
            if (!hash.containsKey(num)) {
                hash.put(num, 1);
            } else {
                hash.put(num, 2);
            }
        }
        return hash.entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No single number in array"))
                .getKey();
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));
    }
}
