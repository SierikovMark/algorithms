package org.algorithms.leetcode.easy;

public class ImplementationStrStr {

    public static int strStr(String haystack, String needle) {

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
    }
}
