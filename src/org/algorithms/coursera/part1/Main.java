package org.algorithms.coursera.part1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {

        int N = StdIn.readInt();

        UF uf = new UF(N);

        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();

            if (!uf.connected(p, q)) {
                uf.union(p, q);
                StdOut.println("p=" + p + " " + "q=" + q);
            }
        }
    }
}

class UF {
    public UF(int size) {
    }

    public void union(int a, int b) {

    }

    public boolean connected(int a, int b) {
        return false;
    }
}

class QuickFindUF {
    private int[] ids;

    public QuickFindUF(int N) {
        ids = new int[N];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;

        }
    }

    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }

    public void union(int p, int q) {
        int pid = ids[p];
        int qid = ids[q];

        if (pid == qid) return;

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pid) ids[i] = qid;
        }

    }
}
