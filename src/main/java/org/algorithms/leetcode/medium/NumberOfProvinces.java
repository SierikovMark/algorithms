package org.algorithms.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        if (length == 0 || length == 1) {
            return length;
        }
        int groups = 0;
        Set<Integer> traversedNodes = new HashSet<>();
        for (int i = 0; i < length; i++) {
            if (traversedNodes.contains(i)) {
                continue;
            }
            traversedNodes.add(i);
            traverseGraph(i, isConnected, traversedNodes);
            groups++;
        }
        return groups;
    }

    private static void traverseGraph(int nodePosition, int[][] isConnected, Set<Integer> traversedNodes) {
        int[] nodeRelations = isConnected[nodePosition];
        for (int i = 0; i < nodeRelations.length; i++) {
            if (nodePosition == i) {
                continue;
            }
            if (nodeRelations[i] == 1 && !traversedNodes.contains(i)) {
                traversedNodes.add(i);
                traverseGraph(i, isConnected, traversedNodes);
            }
        }
    }

    public static void main(String[] args) {
        int numberOfProvince = findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        });

        System.out.println("Expected amount of province is 2, actual amount is " + numberOfProvince);
    }
}
