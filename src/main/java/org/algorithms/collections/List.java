package org.algorithms.collections;

public interface List<T> extends Iterable<T>{

    void add(T element);

    T get(int index);

    void remove(T element);

    void remove(int index);

    T lastNode();

    T firstNode();

    int size();

    boolean isEmpty();
}
