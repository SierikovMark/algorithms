package org.algorithms.leetcode.easy;

public class ExcelSheetColumnTitle {

    // Time Complexity = n / 26 + n / 26 + n / 26 + ... + ~ O(n/26) ~ O(n)
    public static String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int rest = columnNumber % 26;
            result.insert(0, (char) ('A' + rest));
            columnNumber /= 26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(701));
    }
}
