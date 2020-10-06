package org.algorithms.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new ListNode();
        }
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        }

        ListNode result = null;
        ListNode firstNode = null;
        boolean additional = false;
        while(l1 != null || l2 != null) {
            int firstValue = l1 == null ? 0 : l1.val;
            int secondValue = l2 == null ? 0 : l2.val;

            int resultValue = firstValue + secondValue;

            if (additional) {
                resultValue += 1;
                additional = false;
            }

            if (resultValue >= 10) {
                resultValue %= 10;
                additional = true;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            if (result == null) {
                result = new ListNode(resultValue);
                firstNode = result;
                continue;
            }

            result.next = new ListNode(resultValue);
            result = result.next;
        }
        if (additional) {
            result.next = new ListNode(1);
        }
        return firstNode;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode listNode = addTwoNumbers(l1, l2);
        printList(listNode);

        System.out.println();
        l1 = new ListNode(1, new ListNode(8));
        l2 = new ListNode(0);

        listNode = addTwoNumbers(l1, l2);
        printList(listNode);
    }

    private static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}