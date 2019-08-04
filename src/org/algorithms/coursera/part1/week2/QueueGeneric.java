package org.algorithms.coursera.part1.week2;

public interface QueueGeneric<T> extends Iterable<T> {

    void  endueue(T item);

    T dequeue();

    boolean isEmpty();

    int size();
}
