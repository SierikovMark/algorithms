package org.algorithms.leetcode.common;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(val);
        ListNode tmp = next;
        while (tmp != null) {
            stringBuilder.append(" ");
            stringBuilder.append(tmp.val);
            tmp = tmp.next;
        }
        return stringBuilder.toString();
    }
}
