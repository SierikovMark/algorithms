package org.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        Set<Integer> rowsToReplace = new HashSet<>();
        Set<Integer> columnsToReplace = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == 0) {
                    rowsToReplace.add(i);
                    columnsToReplace.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (rowsToReplace.contains(i) || columnsToReplace.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroesV2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rowsLength = matrix.length;
        int columnsLength = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColumnZero = false;

        // check either first row should be replaced with 0
        for (int j = 0; j < columnsLength; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // check either first column should be replaced with 0
        for (int[] rows : matrix) {
            if (rows[0] == 0) {
                firstColumnZero = true;
                break;
            }
        }

        // iterate from second row and second column,
        // we will use first row and first column as a storage
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                // if element is zero we should put 0
                // in the first column and first row
                // So later we will use it as a marker that
                // element in this row or column should be replaced
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // iterate starting from second row and second column
        for (int i = 1; i < rowsLength; i++) {
            for (int j = 1; j < columnsLength; j++) {
                // if elemnt in first row and corresponding column marked as zero
                // or if elemnt in first column and corresponding row marked as zero
                // then element should be replaced with 0
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // If all elements in the first row should be replaced
        // we should replace them
        if (firstRowZero) {
            for (int j = 0; j < columnsLength; j++) {
                matrix[0][j] = 0;
            }
        }

        // If all elements in the first column should be replaced
        // we should replace them
        if (firstColumnZero) {
            for (int i = 0; i < rowsLength; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
