package org.algorithms.coursera.part1;


import edu.princeton.cs.algs4.QuickUnionUF;

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

        //quickUnionUF.print();






    }
}



