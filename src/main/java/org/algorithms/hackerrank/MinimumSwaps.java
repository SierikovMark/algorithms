package org.algorithms.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinimumSwaps {

    public static void main(String[] args) {
        int i = minimumSwaps(new int[]{4, 3, 1, 2});
        System.out.println(i);
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Pair(arr[i], i));
        }

        list.sort(Comparator.comparingInt(t -> t.key));

        Boolean[] visited = new Boolean[arr.length];
        Arrays.fill(visited, false);

        int amountOfIterations = 0;
        for (int i = 0; i < arr.length; i++) {
            int value = list.get(i).value;
            if (visited[i] || value == i) {
                continue;
            }

            int pathSize = 0;
            int j = i;
            while (!visited[j]) {
                visited[j] = true;
                j = list.get(j).value;
                pathSize++;
            }

            if (pathSize > 0) {
                amountOfIterations += (pathSize - 1);
            }
        }
        return amountOfIterations;
    }

    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
