package org.algorithms.other;

public class RepeatedString {

    public static void main(String[] args) {
        System.out.println(repeatedString("a", 10000000000L));
    }

    static long repeatedString(String s, long n) {

        if (s.length() < 1 || s.length() > 100 || n < 1 || n > Math.pow(10, 12)) return 0;

        long length = s.length();

        long amountOfIteration = n / length;

        long amountOfAInString = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                amountOfAInString++;
            }
        }

        if (amountOfAInString == 0) return 0;

        long result = amountOfAInString * amountOfIteration;

        int lo = 0;
        long mod = n % length;
        if (mod != 0) {
            while (lo < mod) {
                if (s.charAt(lo) == 'a') result++;
                lo++;
                length++;
            }
        }

        return result;
    }
}
