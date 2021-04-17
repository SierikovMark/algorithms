package org.algorithms.utils;

import org.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Utils {

    private final static int OFFSET_MOD_COUNT = 2;

    public static void printIntArray(int[] arr, int index) {
        if (index > arr.length) throw new IllegalArgumentException("Array length less then required index");
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i]);
            if (i != index - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printIntArray(int[] arr) {
        printIntArray(arr, arr.length);
    }

    // TODO: needs some correction for node value length
    public static void printBFTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        int depth = findDepth(treeNode);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(treeNode);

        int leftOffset = OFFSET_MOD_COUNT * (depth - 1);
        while (!queue.isEmpty()) {
            printOffset(leftOffset);
            int rowSize = queue.size();
            while (rowSize-- > 0) {
                TreeNode node = queue.poll();
                System.out.print(node.val);
                printOffset(OFFSET_MOD_COUNT + 1);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
            leftOffset -= OFFSET_MOD_COUNT;
        }
    }

    private static void printOffset(int amountOfSpaces) {
        System.out.print(" ".repeat(amountOfSpaces));
    }

    private static int findDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(findDepth(treeNode.left), findDepth(treeNode.right));
    }
}

//         1
//       1   1
//     1   1   1
//   1   1   1   1
// 1   1   1   1   1
