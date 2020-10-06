package org.algorithms.coursera.part1.week2.questions;


import java.util.Stack;
import java.lang.RuntimeException;

public class StackOfIntsWithMaxValue {

    private class StackValueWrapper {
        int value;
        Integer prevMax;
    }

    private int max;
    private Stack<StackValueWrapper> stack = new Stack<>();

    public int pop() {
        if (stack.isEmpty()) throw new RuntimeException("Empty stack");
        StackValueWrapper valueWrapper = stack.pop();
        if (valueWrapper.prevMax != null) {
            max = valueWrapper.prevMax;
        }
        return valueWrapper.value;
    }

    public void push(int value) {
        if (stack.isEmpty()) max = value;

        StackValueWrapper valueWrapper = new StackValueWrapper();
        if (value > max) {
            valueWrapper.prevMax = max;
            max = value;
        }
        valueWrapper.value = value;
        stack.push(valueWrapper);
    }

    public int getMax() {
        return max;
    }

    public static void main(String[] args) {

        StackOfIntsWithMaxValue stack = new StackOfIntsWithMaxValue();

        stack.push(1);
        System.out.println(stack.getMax());
        stack.push(2);
        System.out.println(stack.getMax());
        stack.push(3);
        System.out.println(stack.getMax());
        stack.pop();
        System.out.println(stack.getMax());

    }
}