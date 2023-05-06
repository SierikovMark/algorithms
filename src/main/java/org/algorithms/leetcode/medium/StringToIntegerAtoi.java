package org.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class StringToIntegerAtoi {

    public static final int MAX_INT_DIVIDED_BY_10 = Integer.MAX_VALUE / 10;
    public static final int REMINDER_OF_MAX_INT_AND_10 = Integer.MAX_VALUE % 10;
    private final Set<Character> allowedNumbers = new HashSet<>();

    {
        allowedNumbers.add('0');
        allowedNumbers.add('1');
        allowedNumbers.add('2');
        allowedNumbers.add('3');
        allowedNumbers.add('4');
        allowedNumbers.add('5');
        allowedNumbers.add('6');
        allowedNumbers.add('7');
        allowedNumbers.add('8');
        allowedNumbers.add('9');
    }


    public int myAtoi(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 0) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int startIndex = 0;
        for (char c : chars) {
            if (c == ' ') {
                startIndex++;
            } else {
                break;
            }
        }

        boolean positive = true;
        if (startIndex < chars.length - 1) {
            if (chars[startIndex] == '-') {
                startIndex++;
                positive = false;
            } else if (chars[startIndex] == '+') {
                startIndex++;
            }
        }

        if (startIndex < chars.length - 1) {
            if (chars[startIndex] == '-' || chars[startIndex] == '+') {
                return 0;
            }
        }

        StringBuilder resultString = new StringBuilder();
        int amountOfDigits = 0;
        for (int i = startIndex; i < chars.length; i++) {
            char currentChar = chars[i];
            if (allowedNumbers.contains(currentChar)) {
                resultString.append(currentChar);
                amountOfDigits++;
            } else {
                break;
            }
        }

        if (amountOfDigits == 0) {
            return 0;
        }

        try {
            int result = Integer.parseInt(resultString.toString());
            return positive ? result : -1 * result;
        } catch (NumberFormatException e) {
            return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
    }

    public int myAtoiV2(String s) {
        // Null string
        if (s == null) {
            return 0;
        }
        // Empty string
        if (s.length() == 0) {
            return 0;
        }

        // We need control position during the iteration over the string
        int index = 0;
        // We need to determine sign, by default we assume that it is positive sign
        int sign = 1;
        // We will track our result in this variable;
        int result = 0;

        // We will work with array instead of using String.charAt() method
        char[] chars = s.toCharArray();

        // 1. Skip spaces
        while (index < chars.length && chars[index] == ' ') {
            index++;
        }

        // 2. Determine sign
        if (chars[index] == '+' || chars[index] == '-') {
            sign = chars[index] == '-' ? -1 : 1;
            index++;
        }

        // 3. Parse number
        while (index < chars.length) {
            int digit = chars[index] - '0';
            if (digit < 0 || digit > 9) {
                break;
            }

            // Check overflow, after this validation we will multiply our result by 10
            if (MAX_INT_DIVIDED_BY_10 < result
                    // we still have 7 digit in case of Integer.MAX_VALUE
                    || (MAX_INT_DIVIDED_BY_10 == result && REMINDER_OF_MAX_INT_AND_10 < digit
            )) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }

}
