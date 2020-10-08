package org.algorithms.leetcode.easy;

import org.algorithms.collections.ArrayDeque;
import org.algorithms.collections.Deque;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static boolean isPalindromeSecond(int x) {
        if (x < 0) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        while(x != 0) {
            int pop = x % 10;
            deque.push(pop);
            x /= 10;
        }
        while (!deque.isEmpty()) {
            if (!deque.peekFirst().equals(deque.peekLast())) {
                return false;
            }
            deque.poll();
            if (deque.size() > 0) deque.pop();
        }
        return true;
    }

    public static boolean isPalindromeFirst(int x) {
        if (x < 0) return false;
        char[] arr = String.valueOf(x).toCharArray();
        int start = 0, end = arr.length - 1;
        while (start < end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(122));
        System.out.println(isPalindrome(33));
        System.out.println(isPalindrome(-33));

    }
}
