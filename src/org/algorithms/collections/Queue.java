package org.algorithms.collections;

public interface Queue<T> extends Iterable<T> {

    void offer(T element);

    T peek();

    T pop();

    int size();

    boolean isEmpty();
}
