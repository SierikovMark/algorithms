package org.algorithms.collections;

public interface Deque<T> extends Iterable<T> {

    void offer(T element);

    T peek();

    T peekFirst();

    T peekLast();

    T poll();

    T pop();

    void push(T element);

    boolean isEmpty();

    int size();
}
