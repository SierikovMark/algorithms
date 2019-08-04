package org.algorithms.coursera.part1.week2;

import java.util.Iterator;

public class StackGenericBasedOnLinkedList<T> implements StackGeneric<T> {

    private Node first;
    private int size;

    public StackGenericBasedOnLinkedList() {}

    @Override
    public void push(T item) {
        size++;
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }

    @Override
    public T pop() {
        if (first == null) return null;
        size--;
        T item = first.item;
        Node newLastNode = first.next;
        first.next = null;
        first = newLastNode;
        return item;
    }

    @Override
    public T peek() {
        return first.item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ItemIterator();
    }

    private class Node {
        T item;
        Node next;
    }

    private class ItemIterator implements Iterator<T> {

        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T item = node.item;
            node = node.next;
            return item;
        }
    }
}
