package org.algorithms.coursera.part1.week2;

public class StackOfStringsBasedOnLinkedList implements StackOfStrings {

    private Node first;
    private int size;

    public StackOfStringsBasedOnLinkedList() {}

    public void push(String item) {
        size++;
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }

    public String pop() {
        if (first == null) return null;
        size--;
        String item = first.item;
        Node newLastNode = first.next;
        first.next = null;
        first = newLastNode;
        return item;
    }

    public String peek() {
        return first.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private class Node {
        String item;
        Node next;
    }
}


