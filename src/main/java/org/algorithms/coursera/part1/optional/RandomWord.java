package org.algorithms.coursera.part1.optional;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        String winner = null;
        double i = 1.00;
        while (!StdIn.isEmpty()) {
            String string = StdIn.readString();
            boolean select = StdRandom.bernoulli(1 / i);
            if (select || winner == null) {
                winner = string;
            }
            i++;
        }
        System.out.println(winner);
    }
}

