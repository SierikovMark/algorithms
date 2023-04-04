package org.algorithms.leetcode.easy;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int result = 0;
        int mod = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            result += mod * (columnTitle.charAt(i) - 'A' + 1);
            mod *= 26;
        }
        return result;

    }
}
