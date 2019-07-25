package org.algorithms.coursera.part1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {

//        int N = StdIn.readInt();
//
//        UF uf = new UF(N);
//
//        while (!StdIn.isEmpty()) {
//            int p = StdIn.readInt();
//            int q = StdIn.readInt();
//
//            if (!uf.connected(p, q)) {
//                uf.union(p, q);
//                StdOut.println("p=" + p + " " + "q=" + q);
//            }
//        }



        QuickUnionUF quickUnionUF = new QuickUnionUF(10);
        quickUnionUF.union(1,2);
        quickUnionUF.union(3,4);
        quickUnionUF.union(2,3);

        System.out.println(quickUnionUF.connected(1,5));

        quickUnionUF.print();






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

class QuickUnionUF {
    private int[] ids;

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
