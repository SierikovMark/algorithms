package org.algorithms.coursera.part1.week2;

public interface StackGeneric<T> extends Iterable<T> {

    void push(T item);

    T pop();

    T peek();

    boolean isEmpty();

    int size();
}
