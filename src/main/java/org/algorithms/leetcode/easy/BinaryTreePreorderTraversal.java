package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.poll();
            result.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return result;
    }
}
