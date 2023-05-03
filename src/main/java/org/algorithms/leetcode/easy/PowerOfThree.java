package org.algorithms.leetcode.easy;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        long result = Long.MIN_VALUE;
        int i = 0;
        while(result <= n) {
            result = powOfThree(i);

            if (result == n) {
                return true;
            }
            i++;
        }

        return false;
    }

    private long powOfThree(int power) {
        if (power == 0) {
            return 1;
        }
        long result = 3;
        for(int i = 2; i <= power; i++) {
            result *= 3;
        }

        return result;
    }

    public boolean isPowerOfThreeV2(int n) {
        while (n >= 3) {
            if(n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThreeV3(int n) {
        // n = 3 ^ i
        // i = log3(n)
        // i = logB(n) / logB(3)
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }


    public boolean isPowerOfThreeV4(int n) {
        // 3^19 = 1162261467,
        // 3^20 is exceeding Integer Range. So 3^19 is the highest power of 3 in Integer Range
        return (n > 0) && (1162261467 % n == 0);
    }
}
