package org.algorithms.collections;

import java.util.Iterator;

public class LinkedListStack<T> implements Stack<T> {

    private class Node<E> {
        E element;
        Node<E> previous;
    }

    private Node<T> node;
    private int size;

    @Override
    public void push(T element) {
        if (node == null) {
            node = new Node<>();
            node.element = element;
            size++;
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.element = element;
        newNode.previous = node;
        node = newNode;
        size++;
    }

    @Override
    public T peek() {
        return node.element;
    }

    @Override
    public T pop() {
        if (node == null) return null;
        T element = node.element;
        Node<T> previous = node.previous;
        node.previous = null;
        node = previous;
        size--;
        return element;
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
        return new Iterator<T>() {
            Node<T> tNode = node;
            @Override
            public boolean hasNext() {
                return tNode != null;
            }

            @Override
            public T next() {
                Node<T> current = tNode;
                tNode = current.previous;
                return current.element;
            }
        };
    }
}
