package org.algorithms.collections;

public interface Stack<T> extends Iterable<T> {

    void push(T element);

    T peek();

    T pop();

    boolean isEmpty();

    int size();

}
