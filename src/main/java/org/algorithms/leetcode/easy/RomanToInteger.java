package org.algorithms.leetcode.easy;

public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null) return -1;

        int index = s.length() - 1;
        int result = 0;
        while (index >= 0) {
            char current = s.charAt(index);
            if (current == 'I') {
                while (index >= 0 && s.charAt(index) == 'I') {
                    result += 1;
                    index--;
                }
            } else if (current == 'V') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                    result += 4;
                    index -=2;
                } else {
                    result += 5;
                    index--;
                }
            } else if (current == 'X') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'I') {
                    result += 9;
                    index -=2;
                } else {
                    result += 10;
                    index--;
                }
            } else if (current == 'L') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                    result += 40;
                    index -=2;
                } else {
                    result += 50;
                    index--;
                }
            } else if (current == 'C') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'X') {
                    result += 90;
                    index -=2;
                } else {
                    result += 100;
                    index--;
                }
            } else if (current == 'D') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                    result += 400;
                    index -=2;
                } else {
                    result += 500;
                    index--;
                }
            } else if (current == 'M') {
                if (index - 1 >= 0 && s.charAt(index - 1) == 'C') {
                    result += 900;
                    index -=2;
                } else {
                    result += 1000;
                    index--;
                }
            } else {
                return -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
    }
}
