package org.algorithms.cci.datastructure;

public interface Stack<T> {

    void push(T element);

    T peek();

    T pop();

    boolean isEmpty();

    int getSize();

    boolean contains(T element);
}
