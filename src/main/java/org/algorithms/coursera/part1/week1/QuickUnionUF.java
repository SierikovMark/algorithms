package org.algorithms.coursera.part1.week1;

class QuickUnionUF {
    protected int[] ids;

    public QuickUnionUF(int N) {
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;

        }
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        ids[rootP] = rootQ;
    }

    private int findRoot(int p) {
        int id = ids[p];
        if (id != p) {
            id = findRoot(id);
        }
        return id;
    }

    public void print() {
        for (int i = 0; i < ids.length; i++) {
            System.out.println( i + " " + ids[i]);

        }

    }
}