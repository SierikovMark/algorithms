import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] randomizedQueue;
    private int size;

    // construct an empty randomized queue
    public RandomizedQueue() {
        randomizedQueue = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        checkItemIsNotNull(item);
        ensureCapacity();
        randomizedQueue[size] = item;
        size++;
    }

    private void checkItemIsNotNull(Item item) {
        if (item == null) throw new IllegalArgumentException("New element can't be null");
    }

    private void ensureCapacity() {
        if (size > randomizedQueue.length - 1) {
            randomizedQueue =  Arrays.copyOf(randomizedQueue, randomizedQueue.length * 2);
        }
    }

    // remove and return a random item
    public Item dequeue() {
        checkRandomizedQueueIsNotEmpty();
        int randomIndex = StdRandom.uniform(0, size);
        Item item = randomizedQueue[randomIndex];
        if (randomIndex != size - 1) {
            randomizedQueue[randomIndex] = randomizedQueue[size - 1];
            randomizedQueue[size - 1] = null;
        }
        if (size <= randomizedQueue.length / 4) {
            Item[] tempRandomizedQueue = (Item[]) new Object[randomizedQueue.length / 2];
            for (int i = 0; i < size; i++) {
                tempRandomizedQueue[i] = randomizedQueue[i];
            }
            randomizedQueue = tempRandomizedQueue;
        }
        size--;
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        checkRandomizedQueueIsNotEmpty();
        int randomIndex = StdRandom.uniform(0, size);
        return randomizedQueue[randomIndex];
    }

    private void checkRandomizedQueueIsNotEmpty() {
        if (this.isEmpty()) throw new NoSuchElementException();
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private final Item[] ar;
        private int i;

        public RandomizedQueueIterator() {
            ar = (Item[]) new Object[size];
            for (int k = 0; k < size; k++) {
                ar[k] = randomizedQueue[k];
            }
            StdRandom.shuffle(ar);
        }

        @Override
        public Item next() {
            if (i >= ar.length) throw new NoSuchElementException();
            Item item = ar[i];
            i++;
            return item;
        }

        @Override
        public boolean hasNext() {
            return i < ar.length;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<>();
        randomizedQueue.enqueue("1");
        randomizedQueue.enqueue("2");
        System.out.println(randomizedQueue.sample());
    }

}