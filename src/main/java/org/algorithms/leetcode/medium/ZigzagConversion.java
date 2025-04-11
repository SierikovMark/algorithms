package org.algorithms.leetcode.medium;

import org.algorithms.collections.ArrayList;
import org.algorithms.collections.List;

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() < numRows) {
            return s;
        }

        List<StringBuilder> zigzag = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            zigzag.add(new StringBuilder());
        }
        boolean goingDown = true;
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            StringBuilder currentRow = zigzag.get(j);
            currentRow.append(s.charAt(i));
            j += (goingDown ? 1 : -1);

            if (j >= numRows || j < 0 ) {
                j = goingDown ? numRows-2 : 1;
                goingDown = !goingDown;
            }
            i++;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : zigzag) {
            result.append(sb.toString());
        }

        return result.toString();
    }
}
