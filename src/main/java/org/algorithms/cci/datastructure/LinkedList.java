package org.algorithms.cci.datastructure;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public boolean add(T element) {
        if (element == null) {
            return false;
        }
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    /*
     * Removes first element occurrence in the list
     */
    public boolean remove(T element) {
        Node<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) {
                removeNode(currentNode);
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean removeAll(T element) {
        Node<T> currentNode = head;
        boolean isRemoved = false;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) {
                currentNode = removeNode(currentNode);
                isRemoved = true;
            } else {
                currentNode = currentNode.next;
            }
        }
        return isRemoved;
    }

    /* Return next node after deleted one */
    private Node<T> removeNode(Node<T> currentNode) {
        size--;
        Node<T> previous = currentNode.previous;
        Node<T> next = currentNode.next;
        if (previous == null) {
            head = next;
        } else {
            previous.next = next;
        }
        if (next == null) {
            tail = previous;
        } else {
            next.previous = previous;
        }
        if (size == 0) {
            head = null;
            tail = null;
        }
        currentNode.previous = null;
        currentNode.next = null;
        return next;
    }

    public int indexOf(T element) {
        Node<T> currentNode = head;
        int position = 0;
        while (currentNode != null) {
            if (currentNode.value.equals(element)) {
                return position;
            }
            currentNode = currentNode.next;
            position++;
        }
        return -1;
    }

    public T get(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException(size - 1);
        }
        int currentIndex = 0;
        Node<T> currentNode = head;
        while (currentIndex < index) {
            currentIndex++;
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;
            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
    }
}
