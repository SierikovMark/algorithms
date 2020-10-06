package org.algorithms.coursera.part1.week2;

import java.util.Arrays;
import java.util.Iterator;

public class QueueGenericBasedOnArray<T> implements QueueGeneric<T> {

    private final static int INITIAL_SIZE = 8;
    private final static int SIZE_MULTIPLIER = 2;

    private T[] queue;

    private int head;
    private int tail;
    private int capacity = 0;

    public QueueGenericBasedOnArray() {
        this.queue = (T[])new Object[INITIAL_SIZE];
    }

    @Override
    public void endueue(T item) {
        if (tail >= queue.length - 1) {
            if (head > 0) {
                if (queue.length - head >= 0) System.arraycopy(queue, head, queue, 0, queue.length - head);
                tail -= head;
                head = 0;
            } else {
                queue = Arrays.copyOf(queue, queue.length * SIZE_MULTIPLIER);
            }
        }
        queue[tail] = item;
        tail++;
        capacity++;
    }

    @Override
    public T dequeue() {
        T item = queue[head];
        queue[head] = null;
        head++;
        capacity--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator();
    }

    private class ItemIterator implements Iterator<T> {

        private int h = head, t = tail;
        private T[] q = queue;

        @Override
        public boolean hasNext() {
            return h < t;
        }

        @Override
        public T next() {
            return q[h++];
        }
    }
}
