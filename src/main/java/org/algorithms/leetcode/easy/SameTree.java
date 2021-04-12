package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.Pair;
import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        Deque<Pair<TreeNode>> queue = new ArrayDeque<>();
        queue.add(new Pair<>(p, q));

        while (!queue.isEmpty()) {
            Pair<TreeNode> current = queue.poll();
            if (current.firstValue == null && current.secondValue == null) {
                continue;
            }
            if (current.firstValue == null || current.secondValue == null) {
                return false;
            }
            if (current.firstValue.val != current.secondValue.val) {
                return false;
            }
            queue.add(new Pair<>(current.firstValue.left, current.secondValue.left));
            queue.add(new Pair<>(current.firstValue.right, current.secondValue.right));
        }
        return true;
    }

    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        if (!isSameTreeRecursive(p.left, q.left)) {
            return false;
        }

        if (!isSameTreeRecursive(p.right, q.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(21), new TreeNode(22)), new TreeNode(3));
        TreeNode q = new TreeNode(1,  null, new TreeNode(2));

        System.out.println(isSameTree(p, q));
    }
}
