package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> sums = new ArrayDeque<>();
        stack.push(root);
        sums.push(root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int previousSum = sums.pop();
            if (node.left == null && node.right == null && previousSum == targetSum) {
                return true;
            }
            if (node.left != null) {
                stack.push(node.left);
                sums.push(previousSum + node.left.val);
            }
            if (node.right != null) {
                stack.push(node.right);
                sums.push(previousSum + node.right.val);
            }
        }
        return false;
    }

    public static boolean hasPathSumRecursive(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return helper(root.left, root.val, targetSum) || helper(root.right, root.val, targetSum);
    }

    private static boolean helper(TreeNode node, int previousSum, int targetSum) {
        if (node == null) {
            return false;
        }
        int newSum = previousSum + node.val;
        if (node.left == null && node.right == null) {
            return newSum == targetSum;
        }
        return helper(node.left, newSum, targetSum) || helper(node.right, newSum, targetSum);
    }

    public static void main(String[] args) {
        TreeNode treeNode =
                new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(4,
                                        new TreeNode(5),
                                        new TreeNode(6)),
                                new TreeNode(3)),
                        new TreeNode(2,
                                new TreeNode(3),
                                new TreeNode(4,
                                        new TreeNode(6),
                                        new TreeNode(5))));

        System.out.println(hasPathSum(treeNode, 6) + " = " + hasPathSumRecursive(treeNode, 6));
        System.out.println(hasPathSum(treeNode, 22) + " = " + hasPathSumRecursive(treeNode, 22));
        System.out.println(hasPathSum(treeNode, 12) + " = " + hasPathSumRecursive(treeNode, 12));
    }
}
