package org.algorithms.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class ArrayList<T> implements List<T> {

    private T[] list;
    private int size;

    public ArrayList() {
        list = (T[]) new Object[8];
    }

    @Override
    public void add(T element) {
        ensureCapacity();
        list[size++] = element;
    }

    private void ensureCapacity() {
        if (size + 1 > list.length) {
            list = Arrays.copyOf(list, list.length * 2);
        }
    }

    @Override
    public void remove(T element) {
        if (element == null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    fastRemove(i);
                }
            }
        } else {
            for (int i = 0; i < list.length; i++) {
                if (element.equals(list[i])) {
                    fastRemove(i);
                }

            }
        }
    }

    private void fastRemove(int i) {
        int newLastIndex = list.length - i - 1;
        if (newLastIndex > 0) {
            System.arraycopy(list, i + 1, list, i, newLastIndex);
            list[--size] = null;
        }
    }

    @Override
    public void remove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(list, index + 1, list, index, numMoved);
            size--;
        }
    }

    @Override
    public T lastNode() {
        return list[size];
    }

    @Override
    public T firstNode() {
        return list[0];
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

            T[] tmp  = list;
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return tmp[index++];
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }
}
