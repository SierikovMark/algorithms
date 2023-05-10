package org.algorithms.leetcode.medium;

import org.algorithms.leetcode.common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    /*
    *   1. Iterate over whole list in order to find list size
    *   2. If we want to remove head node we need to return just head.next
    *   3. Iterate over whole list second time and stop before node which should be deleted
    *   4. Remove node
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }

        ListNode current = head;
        int length = 0;

        while (current != null) {
            length++;
            current = current.next;
        }

        if (n > length) {
            throw new RuntimeException("Out of bounds");
        }

        int nodeIndexToRemove = length - n;

        if (nodeIndexToRemove == 0) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        ListNode iteration = head;
        int index = 0;
        while (iteration != null && index < nodeIndexToRemove - 1) {
            index++;
            iteration = iteration.next;
        }

        ListNode nodeToRemove = iteration.next;
        iteration.next = iteration.next == null ? null : iteration.next.next;
        if (nodeToRemove != null) {
            nodeToRemove.next = null;
        }

        return head;
    }

    /*
    *  1. Start first pointer and skip n nodes
    *  2. If first pointer next node is null it means that we want to remove head node,
    *     return head.next in this case
    *  3. Start second pointer along with first pointer until firstPointer.next is not null
    *     firstPointer will be right before node which should be deleted
    *  4. Remove node
     */
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }

        ListNode fast = head;
        int index = 1;
        while (index <= n) {
            fast = fast.next;
            index++;
        }

        if (fast == null) {
            ListNode newHead = head.next;
            head.next = null;
            return newHead;
        }

        ListNode slow = head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode nodeToRemove = slow.next;
        slow.next = slow.next == null ? null : slow.next.next;
        if (nodeToRemove != null) {
            nodeToRemove.next = null;
        }
        return head;
    }

    /*
    *  1. Init ArrayList as a helper collection
    *  2. Iterate over ListNode and save each node in the ArrayList
    *  3. If n equals to list size it means that we want to remove first node
    *     so return head.next in this case
    *  4. Take node before node which should be deleted (size - n - 1)
    *  5. Remove the node
     */
    public ListNode removeNthFromEndV3(ListNode head, int n) {
        if (head == null || n < 0) {
            return head;
        }
        List<ListNode> listNodeCache = new ArrayList<>();

        ListNode iteration = head;
        while (iteration != null) {
            listNodeCache.add(iteration);
            iteration = iteration.next;
        }

        int listSize = listNodeCache.size();
        if (listSize == n) {
            ListNode nodeToRemove = head;
            head = head.next;
            nodeToRemove.next = null;
            return head;
        }

        ListNode listNodeBeforeDeletableNode = listNodeCache.get(listSize - n - 1);
        listNodeBeforeDeletableNode.next = listNodeBeforeDeletableNode.next == null ? null : listNodeBeforeDeletableNode.next.next;

        ListNode nodeToRemove = listNodeCache.get(listSize - n);
        nodeToRemove.next = null;

        return head;
    }
}
