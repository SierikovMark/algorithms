package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    // time complexity = O(n), no extra space (O(1))
    public static boolean hasCycleConstantSpace(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode firstPointer = head;
        ListNode secondPointer = head;
        while (secondPointer.next != null && secondPointer.next.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if (firstPointer == secondPointer) {
                return true;
            }
        }
        return false;
    }

    // time complexity = O(n), space complexity = O(n)
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        Set<ListNode> cache = new HashSet<>();
        while (head != null) {
            if (cache.contains(head)) {
                return true;
            }
            cache.add(head);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode firstNode = new ListNode(1);
        ListNode secondNode = new ListNode(1);
        ListNode thirdNode = new ListNode(1);
        ListNode fourthNode = new ListNode(1);
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = thirdNode;

        System.out.println(hasCycle(firstNode) + " = " + hasCycleConstantSpace(firstNode));

        fourthNode.next = null;
        System.out.println(hasCycle(firstNode) + " = " + hasCycleConstantSpace(firstNode));
    }
}
