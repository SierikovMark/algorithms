package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);

        while (!deque.isEmpty()) {
            int sizeOfRow = deque.size();
            while (sizeOfRow-- > 0) {
                TreeNode currentNode = deque.poll();
                if (currentNode.left != null) {
                    deque.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    deque.offer(currentNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static int maxDepthRecursive(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return depth;
        }

        int depthOfLeftSubTree = maxDepthRecursive(root.left);
        int depthOfRightSubTree = maxDepthRecursive(root.right);

        return 1 + Math.max(depthOfLeftSubTree, depthOfRightSubTree);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(5), new TreeNode(6)), new TreeNode(3)),
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4, new TreeNode(6), new TreeNode(5))));
        System.out.println(maxDepth(treeNode));
        System.out.println(maxDepthRecursive(treeNode));
    }
}
