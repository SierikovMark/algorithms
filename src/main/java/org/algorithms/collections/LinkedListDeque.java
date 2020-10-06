package org.algorithms.collections;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T> {

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> previous;
    }

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    @Override
    public void offer(T element) {
        Node<T> node = new Node<>();
        node.element = element;
        node.previous = lastNode;
        if (firstNode == null) {
            firstNode = node;
        } else {
            lastNode.next = node;
        }
        lastNode = node;
        size++;
    }

    @Override
    public T peek() {
        return firstNode == null ? null : firstNode.element;
    }

    @Override
    public T peekFirst() {
        return peek();
    }

    @Override
    public T peekLast() {
        return lastNode == null ? null : lastNode.element;
    }

    @Override
    public T poll() {
        return pop();
    }

    @Override
    public T pop() {
        if (firstNode == null) return null;
        T element = firstNode.element;
        Node<T> next = firstNode.next;
        if (next == null) {
            lastNode = null;
        } else {
            next.previous = null;
        }
        firstNode = next;
        size--;
        return element;
    }

    @Override
    public void push(T element) {
        Node<T> node = new Node<>();
        node.element = element;
        node.next = firstNode;
        if (lastNode == null) {
            lastNode = node;
        } else {
            firstNode.previous = node;
        }
        firstNode = node;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> tmp = firstNode;

            @Override
            public boolean hasNext() {
                return tmp != null;
            }

            @Override
            public T next() {
                T element = tmp.element;
                tmp = tmp.next;
                return element;
            }
        };
    }
}
