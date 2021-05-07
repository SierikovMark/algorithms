package org.algorithms.cci.datastructure.impl;

import org.algorithms.cci.datastructure.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashMap<K, V> implements Map<K, V> {

    public static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        protected int getHash() {
            return hash;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        protected Entry<K, V> getNext() {
            return next;
        }
    }

    private final static int INITIAL_CAPACITY = 2;

    private Entry<K, V>[] table;
    private int size = 0;

    @SuppressWarnings({"unchecked"})
    public HashMap() {
        table = (Entry<K, V>[]) new Entry[INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        verifyKey(key);
        int hash = getHash(key);
        int bucket = getBucket(hash);
        if (table[bucket] == null) {
            table[bucket] = new Entry<>(hash, key, value, null);
        } else {
            Entry<K, V> entry = table[bucket];
            table[bucket] = new Entry<>(hash, key, value, entry);
        }
        size++;
        ensureCapacity();
    }

    private void ensureCapacity() {
        if (size + 1 > table.length) {
            copyHashMap(table.length * 2);
        }
    }

    private void verifyKey(K key) {
        if (key == null) {
            throw new IllegalStateException("Null keys are not supported");
        }
    }

    private int getHash(K key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public void putAll(Map<K, V> map) {
        if (map.size() + size + 1 > table.length) {
            ensureCapacity(map.size());
        }
        map.entrySet().forEach(entrySet -> this.put(entrySet.getKey(), entrySet.getValue()));
    }

    private void ensureCapacity(int size) {
        int newSize = table.length;
        while (newSize <= size + this.size) {
            newSize *= 2;
        }
        copyHashMap(newSize);
    }

    @SuppressWarnings("unchecked")
    private void copyHashMap(int newSize) {
        Entry<K, V>[] table = this.table;
        this.table = (Entry<K, V>[]) new Entry[newSize];
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                int bucket = getBucket(entry.getHash());
                this.table[bucket] = entry;
            }
        }
    }

    @Override
    public boolean containsKey(K key) {
        int bucket = getBucket(getHash(key));
        return table[bucket] != null;
    }

    private int getBucket(int hash) {
        return (table.length - 1) & hash;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(K key) {
        int bucket = getBucket(key);
        Entry<K, V> entry = table[bucket];
        if (entry == null) {
            return false;
        }
        Entry<K, V> prevEntry = null;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                size--;
                if (prevEntry == null) {
                    table[bucket] = entry.getNext();
                    return true;
                }
                prevEntry.next = entry.getNext();
                entry.next = null;
                return true;
            }
            prevEntry = entry;
            entry = entry.getNext();
        }
        return false;
    }

    private int getBucket(K key) {
        return getBucket(getHash(key));
    }

    @Override
    public List<V> values() {
        List<V> values = new ArrayList<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                while (entry != null) {
                    values.add(entry.getValue());
                    entry = entry.getNext();
                }
            }
        }
        return values;
    }

    @Override
    public Set<K> keys() {
        Set<K> keys = new HashSet<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                while (entry != null) {
                    keys.add(entry.getKey());
                    entry = entry.getNext();
                }
            }
        }
        return keys;
    }

    @Override
    public void clear() {
        Arrays.fill(table, null);
        size = 0;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                while (entry != null) {
                    entrySet.add(entry);
                    entry = entry.getNext();
                }
            }
        }
        return entrySet;
    }
}
