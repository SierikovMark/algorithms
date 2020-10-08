package org.algorithms.leetcode.easy;

public class ReverseInteger {

    // 7 is a last number in Integer.MAX_VALUE () and -8 the last number in Integer.MIN_VALUE
    public static int reverse(int x) {
        int reversed = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            reversed = reversed * 10 + pop;
        }
        return reversed;
    }

    public static int reverseFirstImplementation(int x) {
        String s = String.valueOf(x);
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length - 1;
        if (arr[0] == '-') {
            start = 1;
        }
        while(start <= end) {
            char tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
        long value = Long.parseLong(String.valueOf(arr));
        if (value > Integer.MAX_VALUE || value < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) value;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
