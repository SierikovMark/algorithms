package org.algorithms.leetcode.medium;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || board == null) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wordFound(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    * Time complexity O(n * m * 4*l) ~ O(n * m * l)
    * Space complexity O(n * m * 4*l) ~ O(n * m * l)
    * where n - amount of row, m - amount of column. l - length of word
     */
    private boolean wordFound(char[][] board, String word, int index, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] == '0') {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }
        if (index + 1 >= word.length()) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        if (wordFound(board, word, index + 1, i + 1, j)
                || wordFound(board, word, index + 1, i - 1, j)
                || wordFound(board, word, index + 1, i, j + 1)
                || wordFound(board, word, index + 1, i, j - 1)) {
            return true;
        }
        board[i][j] = tmp;
        return false;
    }
}
