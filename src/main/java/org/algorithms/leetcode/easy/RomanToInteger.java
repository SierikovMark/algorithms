package org.algorithms.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String s) {
        if (s == null) return -1;

        int index = s.length() - 2;
        char[] arr = s.toCharArray();
        int result = getValue(arr[index + 1]);
        while (index >= 0) {
            if (getValue(arr[index]) < getValue(arr[index + 1])) {
                result -= getValue(arr[index]);
            } else {
                result += getValue(arr[index]);
            }
            index--;
        }
        return result;
    }

    private static int getValue(char c) {
        if (c == 'I') {
            return 1;
        } else if (c == 'V') {
            return 5;
        } else if (c == 'X') {
            return 10;
        } else if (c == 'L') {
            return 50;
        } else if (c == 'C') {
            return 100;
        } else if (c == 'D') {
            return 500;
        } else if (c == 'M') {
            return 1000;
        } else {
            throw new IllegalArgumentException("Unrecognized character: " + c);
        }
    }

    private final static Map<Character, Integer> VALUES = new HashMap<>();

    static {
        VALUES.put('I', 1);
        VALUES.put('V', 5);
        VALUES.put('X', 10);
        VALUES.put('L', 50);
        VALUES.put('C', 100);
        VALUES.put('D', 500);
        VALUES.put('M', 1000);
    }

    public static int romanToIntSecond(String s) {
        if (s == null) return -1;

        int index = s.length() - 2;
        char[] arr = s.toCharArray();
        int result = VALUES.get(arr[index + 1]);
        while (index >= 0) {
            if (VALUES.get(arr[index]) < VALUES.get(arr[index + 1])) {
                result -= VALUES.get(arr[index]);
            } else {
                result += VALUES.get(arr[index]);
            }
            index--;
        }
        return result;
    }

    public static int romanToIntFirst(String s) {
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
