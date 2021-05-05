package org.algorithms.cci.datastructure.impl;

import org.algorithms.cci.datastructure.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack = (T[]) new Object[8];
    private int tail = 0;
    private int size = 0;

    @Override
    public void push(T element) {
        ensureCapacity();
        stack[tail++] = element;
        size++;
    }

    private void ensureCapacity() {
        if (tail + 1 > stack.length) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
    }

    @Override
    public T peek() {
        return stack[tail - 1];
    }

    @Override
    public T pop() {
        if (size == 0) {
            throw new NoSuchElementException("Stack is Empty");
        }
        if (tail > 8 && tail <= stack.length / 4) {
            stack = Arrays.copyOf(stack, stack.length / 2);
        }
        size--;
        return stack[--tail];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean contains(T element) {
        for (int i = tail - 1; i >=0; i--) {
            if (stack[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Stack[");
        for (int i = tail - 1; i >=0; i--) {
            stringBuilder.append(stack[i]);
            if (i > 0) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
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
