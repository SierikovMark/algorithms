package org.algorithms.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int head = -1;

    public ArrayStack() {
        stack = (T[]) new Object[8];
    }

    @Override
    public void push(T element) {
        ensureCapacity();
        stack[++head] = element;
    }

    private void ensureCapacity() {
        if (head + 1 > stack.length) {
            stack = Arrays.copyOf(stack, stack.length * 2);
        }
    }

    @Override
    public T peek() {
        return stack[head];
    }

    @Override
    public T pop() {
        if (head <= -1) return null;
        T t = stack[head];
        stack[head--] = null;
        if (head < stack.length / 2) {
            stack = Arrays.copyOf(stack, stack.length / 2);
        }
        return t;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return head + 1;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T[] tmp = stack;
            int tmpPosition = head;

            @Override
            public boolean hasNext() {
                return tmpPosition > -1;
            }

            @Override
            public T next() {
                return tmp[tmpPosition--];
            }
        };
    }
}
