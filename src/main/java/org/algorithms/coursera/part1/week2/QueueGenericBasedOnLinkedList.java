package org.algorithms.coursera.part1.week2;

import java.util.Iterator;

public class QueueGenericBasedOnLinkedList<T> implements QueueGeneric<T> {

    private Node lastNode;
    private Node firstNode;
    private int size;

    public QueueGenericBasedOnLinkedList() {}

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator();
    }

    private class Node {
        T item;
        Node prev;
    }

    @Override
    public void endueue(T item) {
        size++;
        if (lastNode == null) {
            lastNode = new Node();
            lastNode.item = item;
            firstNode = lastNode;
            return;
        }

        Node node = new Node();
        node.item = item;

        lastNode.prev = node;
        lastNode = node;
    }

    @Override
    public T dequeue() {
        if (firstNode == null) return null;
        size--;
        T item = firstNode.item;
        firstNode = firstNode.prev;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    private class ItemIterator implements Iterator<T> {

        private Node s = firstNode;

        @Override
        public boolean hasNext() {
            return s != null;
        }

        @Override
        public T next() {
            T item = s.item;
            s = s.prev;
            return item;
        }
    }
}
