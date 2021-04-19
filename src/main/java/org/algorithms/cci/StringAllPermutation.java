package org.algorithms.cci;

public class StringAllPermutation {

    public static void permutation(String str) {
        permutation(str, "");
    }

    private static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            // We will do 'n' choices for each call of permutation,
            // so it is like n * (n - 1) * (n - 2) * (n - 3) * ... * 1 = n!
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        permutation("1234");
    }
}
