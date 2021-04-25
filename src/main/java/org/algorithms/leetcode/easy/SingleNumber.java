package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

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
