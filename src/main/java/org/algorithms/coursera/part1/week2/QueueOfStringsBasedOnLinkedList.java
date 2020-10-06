package org.algorithms.coursera.part1.week2;

public class QueueOfStringsBasedOnLinkedList implements QueueOfStrings {

    private Node lastNode;
    private Node firstNode;
    private int size;

    public QueueOfStringsBasedOnLinkedList() {}

    private class Node {
        String item;
        Node prev;
    }

    @Override
    public void endueue(String item) {
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
    public String dequeue() {
        if (firstNode == null) return null;
        size--;
        String item = firstNode.item;
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
