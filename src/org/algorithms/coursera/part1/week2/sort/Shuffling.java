package org.algorithms.coursera.part1.week2.sort;

import java.util.Random;

public class Shuffling {

    public static void shuffle(Object[] ar) {
        Random random = new Random();
        for (int i = 1; i < ar.length; i++) {
            int newPosition = random.nextInt(i + 1);
            if (newPosition != i) {
                Object temp = ar[i];
                ar[i] = ar[newPosition];
                ar[newPosition] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] ar = {1, 2, 3, 4, 5, 6};

        shuffle(ar);

        for (Object o : ar) {
            System.out.println(o);
        }

    }



}