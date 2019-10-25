package org.algorithms.collections;

public interface List<T> extends Iterable<T>{

    void add(T element);

    void remove(T element);

    void remove(int index);

    int size();
}
