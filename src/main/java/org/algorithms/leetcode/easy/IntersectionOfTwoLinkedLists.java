package org.algorithms.leetcode.easy;

import org.algorithms.leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    // 1 2 5 6 7 | 3 5 6 7
    // 3 5 6 7 | 1 2 5 6 7

    // 1 2 3 | 4 5
    // 4 5 | 1 2 3

    // Time complexity it is O(length(headA) + length(headB))
    // Space complexity is O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode firstPointer = headA;
        ListNode secondPointer = headB;
        while (firstPointer != secondPointer) {
            if (firstPointer == null) {
                firstPointer = headB;
            } else {
                firstPointer = firstPointer.next;
            }
            if (secondPointer == null) {
                secondPointer = headA;
            } else {
                secondPointer = secondPointer.next;
            }
        }
        return firstPointer;
    }


    // Time complexity it is O(length(headA) + length(headB))
    // Space complexity is O(min(length(headA), length(headB)))
    public static ListNode getIntersectionNodeWithSet(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // In order to have less extra space, we will store in hash shorter list
        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }
        Set<ListNode> hash = new HashSet<>();
        while (headB != null) {
            hash.add(headB);
            headB = headB.next;
        }

        while (headA != null) {
            if (hash.contains(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }

    // Start iteration from the point where both lists have same amount of node till end
    // time complexity is O(length(headA) + length(headB) + abs(length(headA) - length(headB))) =
    //      O(max(length(headA), length(headB))), space complexity is O(1)
    public static ListNode getIntersectionNodeSkipFirstNodesInLongestList(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lengthA = length(headA);
        int lengthB = length(headB);
        if (lengthA < lengthB) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;
        }

        int difference = Math.abs(lengthA - lengthB);
        while (difference-- > 0) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    private static int length(ListNode listNode) {
        int length = 0;
        while (listNode != null) {
            length++;
            listNode = listNode.next;
        }
        return length;
    }

    // Brute Force approach, time complexity O(length(headA) * length(headB)), no extra space
    public static ListNode getIntersectionNodeBruteForce(ListNode headA, ListNode headB) {
        while (headA != null) {
            ListNode tmp = headB;
            while (tmp != null) {
                if (headA == tmp) {
                    return headA;
                }
                tmp = tmp.next;
            }
            headA = headA.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode intersection = new ListNode(5, new ListNode(6, new ListNode(7)));
        ListNode a = new ListNode(1, new ListNode(2, intersection));
        ListNode b = new ListNode(3, intersection);
        System.out.println(getIntersectionNode(a, b));

        ListNode x = new ListNode(1, new ListNode(2));
        ListNode y = new ListNode(3);
        System.out.println(getIntersectionNode(x, y));
    }
}
