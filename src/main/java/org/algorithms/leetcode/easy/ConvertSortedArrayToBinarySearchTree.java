package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.algorithms.utils.Utils.printBFTreeNode;

public class ConvertSortedArrayToBinarySearchTree {

    public static final int PLACEHOLDER = -1;

    private static class Indexes {
        int low;
        int high;

        public Indexes(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Indexes> indexesStack = new ArrayDeque<>();
        TreeNode rootNode = new TreeNode(PLACEHOLDER);
        nodeStack.push(rootNode);
        indexesStack.add(new Indexes(0, nums.length - 1));

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            Indexes indexes = indexesStack.pop();
            int mid = (indexes.low + indexes.high) / 2;
            node.val = nums[mid];
            if (indexes.low <= mid - 1) {
                node.left = new TreeNode(PLACEHOLDER);
                nodeStack.push(node.left);
                indexesStack.push(new Indexes(indexes.low, mid - 1));
            }
            if (mid + 1 <= indexes.high) {
                node.right = new TreeNode(PLACEHOLDER);
                nodeStack.push(node.right);
                indexesStack.push(new Indexes(mid + 1, indexes.high));
            }
        }
        return rootNode;
    }

    public static TreeNode sortedArrayToBSTRecursive(int[] nums) {
        return buildSubTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildSubTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int middle = (start + end) / 2;
        TreeNode node = createNode(nums, middle);
        node.left = buildSubTree(nums, start, middle - 1);
        node.right = buildSubTree(nums, middle + 1, end);
        return node;
    }

    private static TreeNode createNode(int[] nums, int index) {
        return new TreeNode(nums[index]);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = sortedArrayToBST(new int[] {-10,-3,0,5,9});
        printBFTreeNode(treeNode1);

        TreeNode treeNode = sortedArrayToBSTRecursive(new int[] {-10,-3,0,5,9});
        printBFTreeNode(treeNode);
    }
}