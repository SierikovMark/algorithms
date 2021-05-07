package org.algorithms.cci.datastructure;

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private final T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public Node<T> getNext() {
            return next;
        }
    }


    @Override
    public void offer(T element) {
        Node<T> node = new Node<>(element);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public T poll() {
        if (size == 0) {
            throw new IllegalStateException("Queue is Empty");
        }
        Node<T> node = head;
        head = node.next;
        node.next = null;
        size--;
        if (size == 0) {
            tail = head;
        }
        return node.getElement();
    }

    @Override
    public T peek() {
        return head.getElement();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T peekFirst() {
        return head.getElement();
    }

    @Override
    public T peekLast() {
        return tail.getElement();
    }
}
