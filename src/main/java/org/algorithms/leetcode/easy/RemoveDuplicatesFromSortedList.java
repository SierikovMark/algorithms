package org.algorithms.leetcode.easy;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicatesWithoutAdditionalVariable(ListNode head) {
        ListNode result = head;
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode result = head;
        while (head != null) {
            ListNode temp = head;
            while (temp.next != null && temp.val == temp.next.val) {
                temp = temp.next;
            }
            head.next = temp.next;
            head = head.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode listNode3 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3)))))));

        listNode1 = deleteDuplicates(listNode1);
        listNode2 = deleteDuplicates(listNode2);
        listNode3 = deleteDuplicates(listNode3);

        printListNode(listNode1);
        printListNode(listNode2);
        printListNode(listNode3);
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val);
            if (listNode.next != null) {
                System.out.print(" ");
            }
            listNode = listNode.next;
        }
        System.out.println();
    }
}
