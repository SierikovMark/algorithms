package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderTree = new ArrayList<>();
        helper(root, inorderTree);
        return inorderTree;
    }

    private static void helper(TreeNode treeNode, List<Integer> inorderTree) {
        if (treeNode == null) {
            return;
        }
        helper(treeNode.left, inorderTree);
        inorderTree.add(treeNode.val);
        helper(treeNode.right, inorderTree);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = inorderTraversal(root);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
