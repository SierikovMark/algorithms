package org.algorithms.leetcode.easy;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        int length = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < length) {
                length = str.length();
            }
        }

        if (length == 0) return "";

        int lastIndex = 0;
        for (int i = 0; i < length; i++) {
            char current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != current) {
                    return i == 0 ? "" : strs[0].substring(0, lastIndex + 1);
                }
            }
            lastIndex = i;
        }
        return strs[0].substring(0, lastIndex + 1);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[] {"aaa", "aaab", "aa"}));
        System.out.println(longestCommonPrefix(new String[] {"flower","flow","flight"}));
    }
}