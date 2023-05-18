package org.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // validate each row
        for (char[] row : board) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char cell = row[j];
                if (cell != '.' && set.contains(cell)) {
                    return false;
                }
                set.add(cell);
            }
        }

        // validate each column
        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (char[] column : board) {
                char cell = column[i];
                if (cell != '.' && set.contains(cell)) {
                    return false;
                }
                set.add(cell);
            }
        }

        // validate each 3x3 rectangle
        return notContainsRepetition(board, 0, 2, 0, 2)
                && notContainsRepetition(board, 0, 2, 3, 5)
                && notContainsRepetition(board, 0, 2, 6, 8)
                && notContainsRepetition(board, 3, 5, 0, 2)
                && notContainsRepetition(board, 3, 5, 3, 5)
                && notContainsRepetition(board, 3, 5, 6, 8)
                && notContainsRepetition(board, 6, 8, 0, 2)
                && notContainsRepetition(board, 6, 8, 3, 5)
                && notContainsRepetition(board, 6, 8, 6, 8);
    }

    private boolean notContainsRepetition(char[][] board, int startRow, int endRow, int startColumn, int endColumn) {
        Set<Character> set = new HashSet<>();
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startColumn; j <= endColumn; j++) {
                char cell = board[i][j];
                if (cell != '.' && set.contains(cell)) {
                    return false;
                }
                set.add(cell);
            }
        }
        return true;
    }

    public boolean isValidSudokuV2(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char cell = board[i][j];
                if (cell == '.') {
                    continue;
                }
                if (!seen.add(cell + " in row " + i)
                        || !seen.add(cell + " in column " + j)
                        || !seen.add(cell + " in block " + i / 3 + "-" + j / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}
