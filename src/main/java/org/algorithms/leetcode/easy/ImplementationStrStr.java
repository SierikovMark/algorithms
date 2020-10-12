package org.algorithms.leetcode.easy;

public class ImplementationStrStr {

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;

        int length = needle.length();
        int[] lps = new int[needle.length()];
        int i = 1;
        int j = 0;
        while (i < length - 1) {
            if (needle.charAt(i) == needle.charAt(j)) {
                lps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[j] = 0;
                    i++;
                }
            }
        }

        i = 0; j = 0;
        while (i < haystack.length() && j < length) {
            if (needle.charAt(j) == haystack.charAt(i)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    j = 0;
                    i++;
                }
            }
        }

        if (j == length - 1) return i - j;
        return -1;
    }

    public static int strStrFirst(String haystack, String needle) {

        if (haystack == null || needle == null) return -1;
        if ("".equals(needle)) return 0;
        if ("".equals(haystack)) return -1;

        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        for (int i = 0; i < haystack.length();) {
            int j = i;
            while (j < haystackArr.length && j - i < needleArr.length && needleArr[j - i] == haystackArr[j]) {
                if (j - i == needleArr.length - 1) return i;
                j++;
            }
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("mississippi", "mississippi"));
    }
}
