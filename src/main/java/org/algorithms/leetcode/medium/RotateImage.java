package org.algorithms.leetcode.medium;

public class RotateImage {

    // Overall we do (matrix.length * 4) * ((matrix.length - 2) * 4) ... ((2) * 4)
    // ~ 4 * matrix.length^matrix.length ~ O(n^n) where n size of the matrix
    public void rotate(int[][] matrix) {
        // We will start rotating from outer "rectangle" and will reduce boundaries
        // 'x' will represent start column for the rotation (will be incremented each iteration)
        // 'y' will represent start row for the rotation (will be decremented on each iteration)
        // so on each iteration we will reduce our "rectangle"
        // another important thing here that y also will represent max 'x' value,
        // since matrix has same width and heights
        int x = 0;
        int y = matrix.length - 1;

        // it makes sense to reduce "rectangle" until it is not less than 1 cell
        while (y - x >= 1) {
            // essentially we have to do 3 transition or swap for each cell, it involves 4 elements
            int[] iTransitionCoordinates = new int[] {y, y, x, x}; // it will keep row position for each transition
            int[] jTransitionCoordinates = new int[] {x, y, y, x}; // it will keep column position for each transition

            // we always should start from most left element of the "rectangle"
            int j = x;

            // we should iterate until column position less than "rectangle" boundaries
            // remember that since our matrix has same width and height 'y' will also represent row boundaries
            while (j < y) {
                // We should do 3 swap or transition
                int transition = 0;
                while (transition < iTransitionCoordinates.length - 1) {
                    // we take coordinates of first element to swap
                    int iCurrent = iTransitionCoordinates[transition];
                    int jCurrent = jTransitionCoordinates[transition];

                    // we take coordinates of second element to swap
                    int iReplace = iTransitionCoordinates[transition + 1];
                    int jReplace = jTransitionCoordinates[transition + 1];

                    // Swap elements with help of XOR without additional variable
                    matrix[iReplace][jReplace] = matrix[iReplace][jReplace] ^ matrix[iCurrent][jCurrent];
                    matrix[iCurrent][jCurrent] = matrix[iReplace][jReplace] ^ matrix[iCurrent][jCurrent];
                    matrix[iReplace][jReplace] = matrix[iReplace][jReplace] ^ matrix[iCurrent][jCurrent];

                    transition++;
                }

                // We have to update row coordinate for some only for certain iteration/elements
                // For example first element will always be taken from the last row
                // But second and fourth elements will change its row
                // For example second coordinate will be decremented from boundaries to 0
                // And fourth will be incremented from 0 to boundaries
                iTransitionCoordinates[1] = iTransitionCoordinates[1] - 1;
                iTransitionCoordinates[3] = iTransitionCoordinates[3] + 1;

                // Same things but only for column
                jTransitionCoordinates[0] = jTransitionCoordinates[0] + 1;
                jTransitionCoordinates[2] = jTransitionCoordinates[2] - 1;

                j++;
            }
            x++;
            y--;
        }
    }



    // Another option here, we can transpose matrix on the first iteration
    // And then just flip it horizontally
    public void rotateV2(int[][] matrix) {

        // Transpose the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
                matrix[j][i] = matrix[i][j] ^ matrix[j][i];
                matrix[i][j] = matrix[i][j] ^ matrix[j][i];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int jToReplace = matrix.length - 1 - j;
                matrix[i][j]          = matrix[i][j] ^ matrix[i][jToReplace];
                matrix[i][jToReplace] = matrix[i][j] ^ matrix[i][jToReplace];
                matrix[i][j]          = matrix[i][j] ^ matrix[i][jToReplace];
            }
        }
    }

    public void rotate180degree(int[][] matrix) {
        int firstRow = 0;
        int lastRow = matrix.length - 1;
        while (firstRow <= lastRow) {
            int firstColumn = 0;
            int lastColumn = matrix.length - 1;
            while (firstColumn < matrix.length && lastColumn >= 0) {
                if (firstRow == lastRow && firstColumn == lastColumn) {
                    break;
                }
                int tmp = matrix[firstRow][firstColumn];
                matrix[firstRow][firstColumn] = matrix[lastRow][lastColumn];
                matrix[lastRow][lastColumn] = tmp;
                firstColumn++;
                lastColumn--;
            }
            firstRow++;
            lastRow--;
        }

    }
}