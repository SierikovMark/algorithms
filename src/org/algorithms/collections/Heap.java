package org.algorithms.collections;

public interface Heap<T> extends Iterable<T> {

    void offer(T element);

    T search(T element);

    int size();

    T poll();

    boolean isEmpty();
}
