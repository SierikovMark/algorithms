package org.algorithms.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class PriorityQueue<T> implements Heap<T> {

    private T[] heap;
    private int size;
    private Comparator<T> comparator;

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        heap = (T[]) new Object[8];
    }

    @Override
    public void offer(T element) {
        ensureCapacity();
        heap[size++] = element;
        fixHeapAfterInsert(size - 1);
    }

    private void fixHeapAfterInsert(int index) {
        int parentIndex = getParent(index);
        while (index != 0 || heap[index] == null) {
            if (comparator.compare(heap[index], heap[parentIndex]) < 0) {
                return;
            } else if (comparator.compare(heap[index], heap[parentIndex]) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = getParent(index);
            } else {
                heap[index] = null;
                size--;
                return;
            }
        }
    }

    private void swap(int index, int parentIndex) {
        T temp = heap[index];
        heap[index] = heap[parentIndex];
        heap[parentIndex] = temp;
    }

    private int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightIndex(int index) {
        return index * 2 + 2;
    }

    private int getParent(int index) {
        return index / 2;
    }

    private void ensureCapacity() {
        if (size >= heap.length) {
            heap = Arrays.copyOf(heap, heap.length * 2);
        }
    }

    @Override
    public T search(T element) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T poll() {
        T t = heap[0];
        fixHeap();
        return t;
    }

    private void fixHeap() {

        size--;
        heap[0] = heap[size];
        heap[size] = null;

        int fixIndex = getIndex(0);

        int currentIndex = 0;
        while (fixIndex < size || heap[fixIndex] != null) {
            if (comparator.compare(heap[currentIndex], heap[fixIndex]) < 0) {
                swap(currentIndex, fixIndex);
                currentIndex = fixIndex;
                fixIndex = getIndex(fixIndex);
            } else {
                return;
            }
        }
    }

    private int getIndex(int fixIndex) {
        if (heap[getLeftIndex(fixIndex)] == null || heap[getRightIndex(fixIndex)] == null) {
            return getLeftIndex(fixIndex);
        }
        if (comparator.compare(heap[getLeftIndex(fixIndex)], heap[getRightIndex(fixIndex)]) < 0) {
            return getRightIndex(fixIndex);
        } else {
            return getLeftIndex(fixIndex);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Queue<Integer> queue = new LinkedListQueue() {{
                offer(0);
            }};

            T[] tmp = heap;

            @Override
            public boolean hasNext() {
                return !queue.isEmpty();
            }

            @Override
            public T next() {
                Integer currentIndex = queue.poll();
                int leftIndex = getLeftIndex(currentIndex);
                int rightIndex = getRightIndex(currentIndex);
                if (leftIndex < size) queue.offer(leftIndex);
                if (rightIndex < size) queue.offer(rightIndex);
                return tmp[currentIndex];
            }
        };
    }
}
