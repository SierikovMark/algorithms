package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {

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
        System.out.println(getRow(3));
    }
}
