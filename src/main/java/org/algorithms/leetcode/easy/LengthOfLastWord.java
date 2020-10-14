package org.algorithms.leetcode.easy;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        int length = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != ' ') {
                length++;
            } else {
                if (length > 0) {
                    return length;
                }
            }
        }
        return length;
    }

    public static int lengthOfLastWordFirst(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] arr = s.toCharArray();
        int length = 0;
        boolean f = true;
        for (char c : arr) {
            if (c != ' ') {
                if (f) {
                    length = 0;
                    f = false;
                }
                length++;
            } else {
                f = true;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("") + " = 0");
        System.out.println(lengthOfLastWord("a ") + " = 1");
        System.out.println(lengthOfLastWord(" a ") + " = 1");
        System.out.println(lengthOfLastWord("aa abb") + " = 3");
        System.out.println(lengthOfLastWord("aaa bb") + " = 2");
    }
}
