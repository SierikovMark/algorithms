package org.algorithms.coursera.part1.week1;

import org.algorithms.coursera.part1.week1.QuickFindWithFindMax;

public class QuickUnionWithMax {

    public static void main(String[] args) {
        QuickFindWithFindMax quickFindWithFindMax = new QuickFindWithFindMax(10);
        quickFindWithFindMax.union(1, 3);
        quickFindWithFindMax.union(7, 9);
        quickFindWithFindMax.union(3, 7);

        System.out.println(quickFindWithFindMax.find(0));
        System.out.println(quickFindWithFindMax.find(3));
    }

    private int[] ids;
    private int[] sz;
    private int maxIds[];


    public QuickUnionWithMax(int N) {
        ids = new int[N];
        sz = new int[N];
        maxIds = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
            maxIds[i] = i;
        }
    }


    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int i) {
        int max = i;
        while (ids[i] != i) {
            if (max < ids[i]) max = ids[i];
            if (max < ids[ids[i]]) max = ids[ids[i]];
            ids[i] = ids[ids[i]];
            i = ids[i];
        }
        maxIds[i] = max;

        return i;
    }

    public int find(int p) {
        int max = p;
        while (ids[p] != p) {
            if (ids[p] > max) max = ids[p];
            p = ids[p];
        }
        return max;
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
