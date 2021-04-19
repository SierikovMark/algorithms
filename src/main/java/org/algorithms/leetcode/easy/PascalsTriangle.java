package org.algorithms.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows <= 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int restNumRows = 1; restNumRows < numRows; restNumRows++) {
            List<Integer> listToAdd = new ArrayList<>();
            List<Integer> previousIteration = result.get(restNumRows - 1);
            listToAdd.add(1);
            for (int i = 0; i < previousIteration.size() - 1; i++) {
                listToAdd.add(previousIteration.get(i) + previousIteration.get(i + 1));
            }
            listToAdd.add(1);
            result.add(listToAdd);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}
