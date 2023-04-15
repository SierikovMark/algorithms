package org.algorithms.leetcode.easy;

public class HappyNumber {

    public boolean isHappy(int n) {
        int fast = n;
        do {
            int currentValue = calculateDigitsSquareSum(n);
            if (currentValue == 1) {
                return true;
            }
            n = currentValue;
            fast = calculateDigitsSquareSum(fast);
            fast = calculateDigitsSquareSum(fast);
        } while (n != fast);
        return false;
    }

    private int calculateDigitsSquareSum(int number) {
        int result = 0;
        while (number > 0) {
            int currentNumber = number % 10;
            result += currentNumber * currentNumber;
            number /= 10;
        }
        return result;
    }
}
