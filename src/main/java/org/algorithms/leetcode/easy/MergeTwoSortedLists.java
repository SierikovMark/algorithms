package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.ListNode;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode();
        ListNode head = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }

        if (l1 != null) {
            result.next = l1;
        }
        if (l2 != null) {
            result.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoListsFirstImp(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode();
        ListNode head = result;
        while (l1 != null || l2 != null) {
            if (l2 == null || l1 != null && l1.val < l2.val) {
                result.val = l1.val;
                l1 = l1.next;
            } else {
                result.val = l2.val;
                l2 = l2.next;
            }
            if (l1 != null || l2 != null) {
                result.next = new ListNode();
                result = result.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode second = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(first, second);
        System.out.println(listNode.toString());
    }
}
