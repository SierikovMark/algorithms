package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        Deque<Integer> stack = new ArrayDeque<>();
        ListNode tmpNode = head;
        while (tmpNode != null) {
            stack.push(tmpNode.val);
            tmpNode = tmpNode.next;
        }

        int halfSize = stack.size() / 2;
        while(halfSize > 0) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
            halfSize--;
        }

        return true;
    }
}
