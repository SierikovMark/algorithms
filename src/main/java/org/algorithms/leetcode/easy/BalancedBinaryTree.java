package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;
public class BalancedBinaryTree {

    public static boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    private static int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = depth(node.left);
        if (leftDepth == -1) return -1;
        int rightDepth = depth(node.right);
        if (rightDepth == -1) return -1;
        if (Math.abs(leftDepth - rightDepth) > 1) return -1;
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static boolean isBalancedFirstSolution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int depthLeft = depthFirstSolution(root.left);
        int depthRight = depthFirstSolution(root.right);

        return Math.abs(depthLeft - depthRight) < 2
                && isBalancedFirstSolution(root.left) && isBalancedFirstSolution(root.right);

    }

    private static int depthFirstSolution(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                    new TreeNode(3), new TreeNode(3)),
                new TreeNode(2, new TreeNode(6), null));

        System.out.println(isBalanced(node));
    }
}
