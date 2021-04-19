package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

    public static List<Integer> getRowOptimisedBySpace(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);

        if (rowIndex < 1) {
            return result;
        }

        for (int i = 1; i <= rowIndex; i++) {
            result.add(0, 1);
            for (int j = 1; j < result.size() - 1; j++) {
                result.set(j, result.get(j) + result.get(j + 1));
            }
        }
        return result;
    }

    // 1 1 2 1
    // 1 3 3 1
    // 1 1 3 3 1
    // 1 4 6 4 1
    // 1 1 4 6 4 1
    // 1 5 10 10 5 1


    public static List<Integer> getRow(int rowIndex) {
        List<Integer> firstElement = new ArrayList<>();
        firstElement.add(1);

        if (rowIndex < 1) {
            return firstElement;
        }

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(firstElement);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for (int j = 0; j < prevRow.size() - 1; j++) {
                newRow.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            newRow.add(1);
            triangle.add(newRow);
        }
        return triangle.get(rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRowOptimisedBySpace(5));
    }
}
