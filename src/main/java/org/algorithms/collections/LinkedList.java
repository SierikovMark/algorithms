package org.algorithms.collections;

import java.util.Iterator;

public class LinkedList<T> implements List<T> {

    private class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;
    }

    private Node<T> node;
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size;

    public LinkedList() {
    }

    @Override
    public void add(T element) {
        if (node == null) {
            node = new Node<>();
            node.element = element;
            firstNode = node;
            lastNode = node;
            size++;
            return;
        }
        Node<T> newNode = new Node<>();
        newNode.element = element;
        newNode.previous = node;
        node.next = newNode;
        node = newNode;
        lastNode = node;
        size++;
    }

    @Override
    public void remove(T element) {

        Node<T> tmp = firstNode;

        while (tmp != null) {
            if (element == null) {
                if (tmp.element == null) {
                    unlink(tmp);
                }
            } else {
                if (element.equals(tmp.element)) {
                    unlink(tmp);
                }
            }
            tmp = tmp.next;
        }
    }

    private void unlink(Node<T> tmp) {
        Node<T> next = tmp.next;
        Node<T> previous = tmp.previous;
        if (previous == null) {
            firstNode = next;
        } else  {
            previous.next = next;
            tmp.previous = null;
        }
        if (next == null) {
            lastNode = previous;
        } else {
            next.previous = previous;
            tmp.next = null;
        }

        tmp.element = null;
        size--;
    }

    @Override
    public void remove(int index) {
        unlink(getNode(index));
    }

    @Override
    public T lastNode() {
        return lastNode == null ? null : lastNode.element;
    }

    @Override
    public T firstNode() {
        return firstNode == null ? null : firstNode.element;
    }

    private Node<T> getNode(int index) {
        Node<T> tmp = firstNode;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                return tmp;
            }
            tmp = tmp.next;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size > 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> tmp = firstNode;
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
