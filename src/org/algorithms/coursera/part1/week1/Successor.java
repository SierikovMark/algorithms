package org.algorithms.coursera.part1.week1;

public class Successor {
    private int[] ids;
    private int[] sz;

    public Successor(int N) {
        ids = new int[N];
        sz = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i + 1;
        }
    }

    public void remove() {

    }


}
