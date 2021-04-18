package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int minDepthRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepthRecursive(root.left);
        int rightDepth = minDepthRecursive(root.right);
        if (leftDepth == 0 && rightDepth > 0) {
            return 1 + rightDepth;
        }
        if (leftDepth > 0 && rightDepth == 0) {
            return 1 + leftDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(3)),
                new TreeNode(2, new TreeNode(6), null));

        System.out.println(minDepth(node) + " = " + minDepthRecursive(node));

        TreeNode node1 = new TreeNode(2,
                null, new TreeNode(3,
                    null, new TreeNode(4,
                        null, new TreeNode(5,
                                null, new TreeNode(6)))));

        System.out.println(minDepth(node1) + " = " + minDepthRecursive(node1));
    }
}
