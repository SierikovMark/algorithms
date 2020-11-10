package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {

    private static final Map<Integer, Integer> CACHE = new HashMap<>();

    static {
        CACHE.put(0, 1);
        CACHE.put(1, 1);
        CACHE.put(2, 2);
    }

    public static int climbStairs(int n) {
        if (n < 0 || n > 45) return -1;
        if (n == 0 || n == 1) return 1;
        if (n == 2) return n;
        int wholePass = 0;
        int firstStep = 1;
        int secondStep = 2;
        int i = 2;
        while (i < n) {
            wholePass = firstStep + secondStep;
            firstStep = secondStep;
            secondStep = wholePass;
            i++;
        }
        return wholePass;
    }

    public static int climbStairsRecursiveApproachWithMemoization(int n) {
        if (n < 0 || n > 45) return -1;

        if (CACHE.containsKey(n)) {
            return CACHE.get(n);
        }
        int currentResult = climbStairs(n - 2) + climbStairs(n - 1);
        CACHE.put(n, currentResult);
        return currentResult;
    }

    public static int climbStairsRecursiveApproach(int n) {
        if (n < 0 || n > 45) return -1;
        if (n == 0 || n == 1) return 1;
        if (n == 2) return n;
        return climbStairs(n - 2) + climbStairs(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(0) + " = 1");
        System.out.println(climbStairs(1) + " = 1");
        System.out.println(climbStairs(2) + " = 2");
        System.out.println(climbStairs(3) + " = 3");
        System.out.println(climbStairs(4) + " = 5");
        System.out.println(climbStairs(5) + " = 8");
    }
}
