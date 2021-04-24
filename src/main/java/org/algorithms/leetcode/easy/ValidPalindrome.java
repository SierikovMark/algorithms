package org.algorithms.leetcode.easy;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();

        int lo = 0, hi = s.length() - 1;
        while (lo <= hi) {
            char lowest = s.charAt(lo);
            char highest = s.charAt(hi);
            if (!Character.isLetterOrDigit(lowest)) {
                lo++;
            } else if (!Character.isLetterOrDigit(highest)) {
                hi--;
            } else {
                if (lowest != highest) {
                    return false;
                }
                lo++;
                hi--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
    }
}
