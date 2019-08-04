package org.algorithms.coursera.part1.week2;

public class QueueGenericBasedOnLinkedList<T> implements QueueGeneric<T> {

    private Node lastNode;
    private Node firstNode;
    private int size;

    public QueueGenericBasedOnLinkedList() {}

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
}
