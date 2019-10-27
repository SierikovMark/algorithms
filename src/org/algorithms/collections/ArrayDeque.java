package org.algorithms.collections;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T> {

    private T[] deque;
    private int size;
    private int head, tail;

    public ArrayDeque() {
        deque = (T[]) new Object[8];
    }

    @Override
    public void offer(T element) {
        deque[tail++] = element;
        size++;
    }

    @Override
    public T peek() {
        return deque[head];
    }

    @Override
    public T peekFirst() {
        return deque[head];
    }

    @Override
    public T peekLast() {
        return deque[tail - 1];
    }

    @Override
    public T poll() {
        return pop();
    }

    @Override
    public T pop() {
        if (head == tail) return null;
        T t = deque[head];
        deque[head] = null;
        head++;
        size--;
        return t;
    }

    @Override
    public void push(T element) {
        ensureHavePlaceForInsertAsFirst();
        deque[--head] = element;
        size++;
    }

    private void ensureHavePlaceForInsertAsFirst() {
        if (head == 0) {
            int shift = 5;
            T[] tmp = (T[]) new Object[deque.length + shift];

            System.arraycopy(deque, 0, tmp, shift, deque.length);
            deque = tmp;
            head = shift;
            tail += shift;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            T[] temp = deque;
            int tmpHead = head;

            @Override
            public boolean hasNext() {
                return temp[tmpHead + 1] != null;
            }

            @Override
            public T next() {
                return temp[tmpHead++];
            }
        };
    }
}
