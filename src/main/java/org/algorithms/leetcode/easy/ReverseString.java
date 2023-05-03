package org.algorithms.leetcode.easy;

public class ReverseString {

    public void reverseString(char[] s) {
        checkInput(s);

        int lo = 0;
        int hi = s.length - 1;

        while (lo < hi) {
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }

    public void reverseStringV2(char[] s) {
        checkInput(s);

        int lo = 0;
        int hi = s.length - 1;

        while (lo < hi) {
            s[lo] = (char) (s[lo] ^ s[hi]);
            s[hi] = (char) (s[lo] ^ s[hi]);
            s[lo] = (char) (s[lo] ^ s[hi]);
            lo++;
            hi--;
        }
    }

    private static void checkInput(char[] s) {
        if (s == null) {
            throw new RuntimeException("Input cannot be null");
        }
    }
}
