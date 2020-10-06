package org.algorithms.collections;

import java.util.List;

public interface Graph<T> extends Iterable<T> {

    void add(T element);

    void remove(T element);

    void connect(T elementFirst, T elementSecond);

    void disconnect(T elementFirst, T elementSecond);

    boolean isConnected(T elementFirst, T elementSecond);

    T search(T element);

    List<T> getNeighbor(T element);

    int size();

    boolean isEmpty();

}
