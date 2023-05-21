package org.algorithms.leetcode.medium;

public class PowXN {

    //  2^10 = 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2
    //  2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 = 2^5 * 2^5
    //  2^5 * 2^5 = 2 * 2^2 * 2^2 * 2 * 2^2 * 2^2
    //  2^4 * 2^4 = 256
    //  2^8 * 2^8 = 6256
    public double myPow(double x, int n) {
        if (x == 0.0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        return n < 0 ? 1 / pow(x, -n) : pow(x, n);

    }

    private double pow(double x, int n) {
        if (n == 1) {
            return x;
        }
        return n % 2 == 0 ? pow(x * x, n / 2) : x * pow(x * x, n / 2);
    }


    // Essentially power of number can be calculated over bit manipulation
    // For example if our power is 9 it is 2^3 + 0^2 + 0^1 + 2^0 = 1001 in binary
    // So x^n = x^(2^3) * x^(0^2) * x^(0^1) * x^(2^0) = x^(2^3) * 1 * 1 * x^(2^0) = x^(2^3) * x^(2^0) = x^(2^i)
    // where i is the ith bit of the exponent
    public double myPowV2(double x, int n) {
        if (x == 0.0) {
            return x;
        }
        if (n == 0) {
            return 1;
        }
        if (n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }
        double result = 1;
        int power = Math.abs(n);
        while (power > 0) {
            if ((power & 1) == 1) {
                result *= x;
            }
            power >>= 1;
            x *= x;
        }

        return n > 0 ? result : 1 / result;

    }
}
