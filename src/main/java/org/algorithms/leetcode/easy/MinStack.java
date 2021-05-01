package org.algorithms.leetcode.easy;

public class MinStack {

    private int[] stack;
    private int tail;

    public MinStack() {
        stack = new int[8];
    }

    // ~ time complexity = O(1), O(n) extra space
    public void push(int val) {
        if (tail + 1 >= stack.length) {
            int[] temp = stack;
            stack = new int[stack.length * 2];
            System.arraycopy(temp, 0, stack, 0, temp.length);
        }
        stack[tail++] = val;
    }

    // time complexity = O(1), no extra space
    public void pop() {
        if (tail - 1 < 0) {
            throw new IllegalStateException();
        }
        tail--;
    }

    // time complexity = O(1), no extra space
    public int top() {
        return stack[tail - 1];
    }

    // time complexity = O(n), constant space
    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tail; i++) {
            if (stack[i] < min) {
                min = stack[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(0);
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
