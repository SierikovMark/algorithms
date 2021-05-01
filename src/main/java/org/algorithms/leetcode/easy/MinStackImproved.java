package org.algorithms.leetcode.easy;

public class MinStackImproved {
    private Node tail;

    public MinStackImproved() {
    }

    // time complexity O(1), space complexity O(1)
    public void push(int val) {
        if (tail == null) {
            tail = new Node(val, val);
        } else {
            int min = Math.min(val, tail.min);
            tail = new Node(val, min, tail);
        }
    }

    // time complexity O(1), no extra space
    public void pop() {
        if (tail == null) {
            throw new IllegalStateException();
        }
        tail = tail.next;
    }

    // time complexity O(1), no extra space
    public int top() {
        return tail.val;
    }

    // time complexity O(1), no extra space
    public int getMin() {
        return tail.min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(0);
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class Node {
    int val;
    int min;
    Node next;
    Node() {}
    Node(int val, int min) {
        this.val = val;
        this.min = min;
    }
    Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}