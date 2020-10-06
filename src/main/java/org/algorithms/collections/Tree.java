package org.algorithms.collections;

public interface Tree<T>  extends Iterable<T> {

    void add(T element);

    T remove(T element);

    T search(T element);

    boolean isEmpty();

    int size();
}
