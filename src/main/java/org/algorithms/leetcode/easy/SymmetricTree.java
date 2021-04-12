package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode node1 = deque.poll();
            TreeNode node2 = deque.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            deque.add(node1.left);
            deque.add(node2.right);
            deque.add(node1.right);
            deque.add(node2.left);
        }
        return true;
    }

    public static boolean isSymmetricRecursive(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.val == node2.val
                && isMirror(node1.left, node2.right)
                && isMirror(node1.right, node2.left);
    }

    public static boolean isSymmetricFirstSolution(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.right == null) {
            return false;
        }
        if (root.left == null) {
            return false;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root.left);
        deque.push(root.right);

        while (!deque.isEmpty()) {
            if (deque.peekLast().val != deque.peekFirst().val) {
                return false;
            }
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();

            if (left.left != null && right.right == null) {
                return false;
            }

            if (left.left == null && right.right != null) {
                return false;
            }

            if (left.left != null) {
                deque.push(left.left);
            }
            if (left.right != null) {
                deque.push(left.right);
            }
            if (right.right != null) {
                deque.offer(right.right);
            }
            if (right.left != null) {
                deque.offer(right.left);
            }
            if (deque.size() % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(5), new TreeNode(6)), new TreeNode(3)),
                new TreeNode(2,
                        new TreeNode(3), new TreeNode(4, new TreeNode(6), new TreeNode(5))));

        System.out.println("is same tree = " + isSymmetric(treeNode1));

        TreeNode treeNode2 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(3)),
                new TreeNode(2, null, new TreeNode(3)));

        System.out.println("is same tree = " + isSymmetric(treeNode2));
    }
}
