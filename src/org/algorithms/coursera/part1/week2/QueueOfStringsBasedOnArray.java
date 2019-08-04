package org.algorithms.coursera.part1.week2;

import java.util.Arrays;

public class QueueOfStringsBasedOnArray implements QueueOfStrings {

    private final static int INITIAL_SIZE = 2;
    private final static int SIZE_MULTIPLIER = 2;

    private String[] queue;

    private int head;
    private int tail;
    private int capacity = 0;

    public QueueOfStringsBasedOnArray() {
        this.queue = new String[INITIAL_SIZE];
    }

    @Override
    public void endueue(String item) {
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
    public String dequeue() {
        String item = queue[head];
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
}
