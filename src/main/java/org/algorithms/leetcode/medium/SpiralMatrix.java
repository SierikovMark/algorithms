package org.algorithms.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // 00 -> 01 -> 02 -> 03 | 13 -> 23 | 22 -> 21 -> 20 | 10 | 11 -> 12

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int i = 0;
        int j = 0;

        int startWidthBound = 0;
        int startHeightBound = 0;
        int widthBound = matrix[0].length - 1;
        int heightBound = matrix.length - 1;

        boolean[][] moveStates = new boolean[][] {
                {true, false, false, false},
                {false, true, false, false},
                {false, false, true, false},
                {false, false, false, true},
        };
        int currentState = 0;
        while (result.size() < matrix.length * matrix[0].length) {

            boolean[] moveState = moveStates[currentState];

            if (moveState[0]) {
                while (j <= widthBound) {
                    result.add(matrix[i][j]);
                    j++;
                }
                j--;
                i++;
                startHeightBound++;
            } else if (moveState[1]) {
                while (i <= heightBound) {
                    result.add(matrix[i][j]);
                    i++;
                }
                i--;
                j--;
                widthBound--;
            } else if (moveState[2]) {
                while (j >= startWidthBound) {
                    result.add(matrix[i][j]);
                    j--;
                }
                j++;
                i--;
                heightBound--;
            } else {
                while (i >= startHeightBound) {
                    result.add(matrix[i][j]);
                    i--;
                }
                i++;
                j++;
                startWidthBound++;
            }
            currentState++;
            if (currentState >= moveStates.length) {
                currentState = 0;
            }
        }

        return result;
    }

    public List<Integer> spiralOrderV2(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }

        int rowStart = 0;
        int rowEnd = matrix.length - 1; // 1

        int columnStart = 0;
        int columnEnd = matrix[0].length - 1; // 2

        while(columnStart <= columnEnd && rowStart <= rowEnd) {
            // Go right
            for (int i = columnStart; i <= columnEnd; i++) {
                result.add(matrix[rowStart][i]); // [1, 2, 3, 4] [6, 7]
            }
            rowStart++; // 2
            // Go down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][columnEnd]); // [8, 12]
            }
            columnEnd--; // 1
            // Go left only if we haven't passed this row
            if (rowStart <= rowEnd) {
                for (int i = columnEnd; i >= columnStart; i--) {
                    result.add(matrix[rowEnd][i]); // [11, 10, 9]
                }
            }
            rowEnd--; // 0
            // Go up only if we haven't passed this column
            if (columnStart <= columnEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][columnStart]); // [5]
                }
            }
            columnStart++; // 2

        }

        return result;
    }
}
