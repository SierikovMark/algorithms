package org.algorithms.collections;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int head, tail;

    public ArrayQueue() {
        queue = (T[]) new Object[8];
    }

    @Override
    public void offer(T element) {
        ensureCapacity();
        queue[tail++] = element;
    }

    private void ensureCapacity() {
        if (tail >= queue.length) {
            queue = Arrays.copyOf(queue, queue.length * 2);
        }
    }

    @Override
    public T peek() {
        return queue[head];
    }

    @Override
    public T pop() {
        if (head == tail) return null;
        T element = queue[head];
        queue[head++] = null;
        shrink();
        return element;
    }

    private void shrink() {
        if (queue.length > 2 && tail - head < queue.length / 2) {
            T[] tmp = (T[]) new Object[queue.length / 2];
            if (tail - head >= 0) System.arraycopy(queue, head, tmp, 0, tail - head);
            queue = tmp;
            tail = tail - head;
            head = 0;
        }
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            T[] tmp = queue;
            int tmpHead = head;

            @Override
            public boolean hasNext() {
                return tmp[tmpHead + 1] != null;
            }

            @Override
            public T next() {
                return tmp[tmpHead++];
            }
        };
    }
}
