package org.algorithms.coursera.part1;

public class QuickUnionWeightedUF {
    private int[] ids;
    private int[] sz;

    public QuickUnionWeightedUF(int N) {
        ids = new int[N];
        sz = new int[N];
        for (int i = 0; i < ids.length; i++) {
             ids[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int i) {
        while (ids[i] != i) {
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int i = findRoot(p);
        int j = findRoot(q);
        if (i == j) return;
        if (sz[i] < sz[j]) {
            ids[i] = j;
            sz[j] += sz[i];
        } else {
            ids[j] = i;
            sz[i] += sz[j];
        }
    }
}
