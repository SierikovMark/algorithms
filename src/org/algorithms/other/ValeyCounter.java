package org.algorithms.other;

public class ValeyCounter {

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "DDUUDDUDUUUD"));
    }

    static int countingValleys(int n, String s) {

        if (n < 2 || n > Math.pow(10, 6)) return 0;

        char[] ar = s.toCharArray();

        int valleyCounter = 0;
        int height = 0;
        for (int i = ar.length - 1; i >= 0; i--) {
            char current = ar[i];
            if (current == 'D') {
                height++;
            }
            if (current == 'U') {
                if (height == 0) valleyCounter++;
                height--;
            }
        }
        return valleyCounter;

    }
}
