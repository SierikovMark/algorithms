package org.algorithms.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {

    public static boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) return false;
        Deque<Character> deque = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (isClosed(c)) {
                if (deque.isEmpty()) {
                    return false;
                }
                if (deque.peek() != getPair(c)) {
                    return false;
                }
                deque.pop();
            } else {
                deque.push(c);
            }
        }
        return deque.isEmpty();
    }

    private static Character getPair(char c) {
        if (c == ')') {
            return '(';
        } else if(c ==']') {
            return '[';
        } else if (c == '}') {
            return '{';
        }
        return null;
    }

    private static boolean isClosed(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    public static void main(String[] args) {
        System.out.println(isValid("[(())]"));
        System.out.println(isValid("]]]]]]]]"));
        System.out.println(isValid("{(})"));
    }
}
