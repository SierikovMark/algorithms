package org.algorithms.cci.datastructure;

public interface Queue<T> {

    void offer(T element);

    T poll();

    T peek();

    int size();

    boolean isEmpty();

    T peekFirst();

    T peekLast();
}
