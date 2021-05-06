package org.algorithms.cci.datastructure;

import org.algorithms.cci.datastructure.impl.HashMap;

import java.util.List;
import java.util.Set;

public interface Map<K, V> {

    void put(K key, V value);

    void putAll(Map<K, V> map);

    boolean containsKey(K key);

    int size();

    boolean isEmpty();

    boolean remove(K key);

    List<V> values();

    Set<K> keys();

    void clear();

    Set<HashMap.Entry<K, V>> entrySet();

}
