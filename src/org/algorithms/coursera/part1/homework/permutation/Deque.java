import java.util.NoSuchElementException;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    private Node firstNode, lastNode;
    private int size;

    // construct an empty deque
    public Deque() { }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        checkItemIsNotNull(item);

        Node oldFirstNode = firstNode;

        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = oldFirstNode;

        if (size > 0) {
            oldFirstNode.prev = firstNode;
        } else {
            lastNode = firstNode;
        }
        size++;
    }

    private void checkItemIsNotNull(Item item) {
        if (item == null) throw new IllegalArgumentException("New element can't be null");
    }

    // add the item to the back
    public void addLast(Item item) {
        checkItemIsNotNull(item);

        Node oldLastNode = lastNode;

        lastNode = new Node();
        lastNode.item = item;
        lastNode.prev = oldLastNode;

        if (size > 0) {
            oldLastNode.next = lastNode;
        } else {
            firstNode = lastNode;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();

        Item item = firstNode.item;

        if (size > 1) {
            Node newFirstNode = firstNode.next;
            newFirstNode.prev = null;
            firstNode = newFirstNode;
        } else {
            lastNode = null;
            firstNode = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (lastNode == null) throw new NoSuchElementException();

        Item item = lastNode.item;

        if (size > 1) {
            Node newLastNode = lastNode.prev;
            newLastNode.next = null;
            lastNode = newLastNode;
        } else {
            lastNode = null;
            firstNode = null;
        }

        size--;
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {

        private Node node = firstNode;

        @Override
        public Item next() {
            if (node == null) throw new NoSuchElementException();
            Node currentNode = node;
            node = node.next;
            return currentNode.item;
        }

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("first");
        deque.addLast("last");
        System.out.println(deque.isEmpty());
        System.out.println(deque.size());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.size());
        System.out.println(deque.isEmpty());

        System.out.println("-----------------------");
        for (String str : deque) {
            System.out.println(str);
        }
        System.out.println("-----------------------");

        deque.addFirst("one");
        deque.addFirst("pone");

        System.out.println("-----------------------");
        for (String str : deque) {
            System.out.println(str);
        }
        System.out.println("-----------------------");

    }

}