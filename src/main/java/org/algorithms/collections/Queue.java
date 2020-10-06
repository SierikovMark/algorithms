package org.algorithms.collections;

public interface Queue<T> extends Iterable<T> {

    void offer(T element);

    T peek();

    T poll();

    int size();

    boolean isEmpty();
}
