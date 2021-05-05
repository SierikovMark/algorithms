package org.algorithms.cci.datastructure.impl;

import org.algorithms.cci.datastructure.Stack;

import java.util.NoSuchElementException;

public class LinkedStack<T> implements Stack<T> {
    private static class StackNode<T> {
        private final T value;
        private StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
        }

        public StackNode(T value, StackNode<T> next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public StackNode<T> getNext() {
            return next;
        }
    }

    private StackNode<T> tail;
    private int size;

    @Override
    public void push(T element) {
        if (element == null) {
            throw new IllegalStateException("Cannot add 'null' value");
        }
        size++;
        tail = new StackNode<>(element, tail);
    }

    @Override
    public T peek() {
        return tail.getValue();
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        size--;
        T element = tail.getValue();
        StackNode<T> next = tail.next;
        tail.next = null;
        tail = next;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        StackNode<T> node = tail;
        while (node != null) {
            if (node.getValue().equals(element)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stack[");
        StackNode<T> node = tail;
        while (node != null) {
            stringBuilder.append(node.getValue());
            if (node.getNext() != null) {
                stringBuilder.append(", ");
            }
            node = node.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        stack.push(23);
        stack.push(11);
        stack.push(4);

        System.out.println(stack.contains(4));
        System.out.println(stack.contains(12));

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        stack.pop();
        stack.pop();
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());
        stack.pop();
    }
}
