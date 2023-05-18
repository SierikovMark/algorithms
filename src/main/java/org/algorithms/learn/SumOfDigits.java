package org.algorithms.learn;

public class SumOfDigits {

    public int sumOfDigits(int number) {
        int sumOfDigits = 0;

        String numberAsString = String.valueOf(number);

        char[] digits = numberAsString.toCharArray();

        for (char digit : digits) {
            sumOfDigits += digit - '0';
        }

        return sumOfDigits;
    }

    public int sumOfDigitsV2(int number) {
        int sumOfDigits = 0;

        while (number > 0) {
            sumOfDigits += number % 10;
            number /= 10;
        }

        return sumOfDigits;
    }
}
