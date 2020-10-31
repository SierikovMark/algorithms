package org.algorithms.leetcode.easy;

public class AddBinary {

    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        if (i > j) return addBinary(b, a);

        j = i - b.length() + 1;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >= 0 && i - j >= 0) {
            int valueB = b.charAt(i - j) - '0';
            result.insert(0, carry ^ a.charAt(i) - '0' ^ valueB);
            carry = (a.charAt(i) - '0' & valueB) | (a.charAt(i) - '0' & carry) | (valueB & carry);
            i--;
        }

        j = b.length() - a.length() - 1;
        while (j >= 0) {
            result.insert(0, carry ^ b.charAt(j) - '0');
            carry = carry & b.charAt(j) - '0';
            j--;
        }

        if (carry == 1) {
            result.insert(0, 1);
        }

        return result.toString();
    }

    public static String addBinaryFirstImproved(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (i >=0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                // Also it is possible to use 'dirty' hack
                // if encoding considers that '1' goes after '0' and '2' goes after '1'
                // we can use `a.charAt(i) - '0'`. Will work for ASCII and Unicode
                sum += Character.getNumericValue(a.charAt(i));
            }
            if (j >= 0) {
                sum += Character.getNumericValue(b.charAt(j));
            }
            result.insert(0, sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        if (carry > 0) {
            result.insert(0, 1);
        }
        return result.toString();
    }

    public static String addBinaryFirst(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        StringBuilder result = new StringBuilder();
        boolean carry = false;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1') {
                if (carry) {
                    result.append('1');
                } else {
                    result.append('0');
                    carry = true;
                }
            } else if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carry) {
                    result.append('1');
                    carry = false;
                } else {
                    result.append('0');
                }
            } else if (a.charAt(i) == '1' || b.charAt(j) == '1') {
                if (carry) {
                    result.append('0');
                } else {
                    result.append('1');
                }
            } else {
                if (carry) {
                    result.append('1');
                    carry = false;
                } else {
                    result.append('0');
                }
            }
            i--;
            j--;
        }

        carry = handleRest(a, i, result, carry);

        carry = handleRest(b, j, result, carry);

        if (carry) {
            result.append('1');
        }

        return result.reverse().toString();

    }

    private static boolean handleRest(String str, int index, StringBuilder result, boolean carry) {
        while (index >= 0) {
            if (str.charAt(index) == '1'  && carry) {
                result.append('0');
            } else if (str.charAt(index) == '0' && carry) {
                result.append('1');
                carry = false;
            } else if (str.charAt(index) == '1') {
                result.append('1');
            } else {
                result.append('0');
            }
            index--;
        }
        return carry;
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println("100");
        System.out.println();

        System.out.println(addBinary("100", "100"));
        System.out.println("1000");
        System.out.println();

        System.out.println(addBinary("100", "111"));
        System.out.println("1011");
        System.out.println();

        System.out.println(addBinary("111", "111"));
        System.out.println("1110");
        System.out.println();

        System.out.println(addBinary("111111", "111"));
        System.out.println("1000110");
        System.out.println();
    }
}
