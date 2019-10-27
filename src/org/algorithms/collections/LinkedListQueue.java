package org.algorithms.collections;

import java.util.Iterator;

public class LinkedListQueue<T> implements Queue<T> {

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
        return lastNode == null ? null : lastNode.element;
    }

    @Override
    public T poll() {
        if (firstNode == null) return null;
        T element = lastNode.element;
        lastNode.element = null;
        Node<T> previous = lastNode.previous;
        if (previous != null) {
            previous.next = null;
        } else {
            firstNode = null;
        }
        lastNode.previous = null;
        lastNode = previous;
        if (previous != null && previous.previous == null) {
            firstNode = lastNode;
        }
        size--;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> tmp = lastNode;
            @Override
            public boolean hasNext() {
                return tmp != null;
            }

            @Override
            public T next() {
                T element = tmp.element;
                tmp = tmp.previous;
                return element;
            }
        };
    }
}
